package io.undertree.evaadapter.api;

import com.overzealous.remark.Remark;
import com.samskivert.mustache.Mustache;
import io.undertree.evaadapter.models.EventAlert;
import io.undertree.evaadapter.models.WebexTeamsMarkdown;
import io.undertree.evaadapter.models.WebexTeamsText;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.Reader;

@Slf4j
@RestController
public class WebhookAdapterController {

    final String webhookUrl;
    final String webhookFormat;
    final RestTemplate restTemplate;
    final Mustache.Compiler mustacheCompiler;
    final Remark remarkConverter = new Remark();

    @Autowired
    public WebhookAdapterController(@Value("${config.webhook.url}") String webhookUrl,
                                    @Value("${config.webhook.format}") String webhookFormat,
                                    RestTemplate restTemplate,
                                    Mustache.Compiler mustacheCompiler) {
        this.webhookUrl = webhookUrl;
        this.webhookFormat = webhookFormat;
        this.restTemplate = restTemplate;
        this.mustacheCompiler = mustacheCompiler;
    }

    @SneakyThrows
    @PostMapping("/")
    public ResponseEntity<?> webhookAdapter(@RequestBody EventAlert eventAlert) {
        log.debug("Event:" + eventAlert);
        log.debug("Webhook URL: " + webhookUrl);

        if (eventAlert.getBody() != null) {
            // attempt to convert the "body" block into markdown
            eventAlert.setBody(remarkConverter.convertFragment(eventAlert.getBody()));
        }

        Reader template = mustacheCompiler.loader.getTemplate(webhookFormat);
        String message = mustacheCompiler.compile(template).execute(eventAlert);

        switch (webhookFormat) {
            case "webex-text":
                return restTemplate.postForEntity(webhookUrl, new WebexTeamsText(message), WebexTeamsText.class);
            case "webex-markdown":
                return restTemplate.postForEntity(webhookUrl, new WebexTeamsMarkdown(message), WebexTeamsMarkdown.class);
            default:
                return ResponseEntity.badRequest().build();
        }
    }
}
