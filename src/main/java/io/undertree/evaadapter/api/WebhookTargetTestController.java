package io.undertree.evaadapter.api;

import io.undertree.evaadapter.models.WebexTeamsMarkdown;
import io.undertree.evaadapter.models.WebexTeamsText;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WebhookTargetTestController {

    @PostMapping("/test/webex-text")
    public void webhookTargetTest(@RequestBody WebexTeamsText message) {
        log.info("Incoming Message = " + message);
        return;
    }

    @PostMapping("/test/webex-markdown")
    public void webhookTargetTest(@RequestBody WebexTeamsMarkdown message) {
        log.info("Incoming Message = " + message);
        return;
    }
}
