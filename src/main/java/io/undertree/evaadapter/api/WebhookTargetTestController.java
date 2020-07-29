package io.undertree.evaadapter.api;

import io.undertree.evaadapter.models.WebexTeamsMarkdown;
import io.undertree.evaadapter.models.WebexTeamsText;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Useful for testing a sample target URL that will accept a POST of a Teams message.
 * This does not do anything but log the message so we can test for conformance once deployed.
 */
@Slf4j
@RestController
public class WebhookTargetTestController {

    @PostMapping("/v1/webhooks/incoming/webex-text")
    public ResponseEntity<Void> webhookTargetTest(@RequestBody WebexTeamsText message) {
        log.info("Incoming message: " + message);
        log.warn("If you are *NOT* testing, alerts are not being routed properly!!!  Please set the WEBHOOK_TARGET_URL.");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/v1/webhooks/incoming/webex-markdown")
    public ResponseEntity<Void> webhookTargetTest(@RequestBody WebexTeamsMarkdown message) {
        log.info("Incoming message: " + message);
        log.warn("If you are *NOT* testing, alerts are not being routed properly!!!  Please set the WEBHOOK_TARGET_URL.");
        return ResponseEntity.ok().build();
    }
}
