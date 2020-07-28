package io.undertree.evaadapter.api;

import io.undertree.evaadapter.models.WebexTeamsMarkdown;
import io.undertree.evaadapter.models.WebexTeamsText;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WebhookTargetTestController {

    @PostMapping("/v1/webhooks/incoming/webex-text")
    public ResponseEntity<?> webhookTargetTest(@RequestBody WebexTeamsText message) {
        log.info("Incoming message: " + message);
        log.warn("If you are *NOT* testing, alerts are not being routed properly!!!  Please set the WEBHOOK_TARGET_URL.");
        return ResponseEntity.ok("");
    }

    @PostMapping("/v1/webhooks/incoming/webex-markdown")
    public ResponseEntity<?> webhookTargetTest(@RequestBody WebexTeamsMarkdown message) {
        log.info("Incoming message: " + message);
        log.warn("If you are *NOT* testing, alerts are not being routed properly!!!  Please set the WEBHOOK_TARGET_URL.");
        return ResponseEntity.ok("");
    }
}
