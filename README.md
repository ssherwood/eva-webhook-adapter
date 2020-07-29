# EVA Webhook Adapter

A simple webhook adapter for EVA with built-in templates for Webex Teams message [format](https://apphub.webex.com/teams/applications/incoming-webhooks-cisco-systems).
This project uses a mustache templating approach and should be extensible for other webhook formats as well.

## Required Configuration

- The target webhook URL should be provided in an environment variable called `WEBHOOK_TARGET_URL`.  If this is not set,
the call will fail to resolve.
- The default format is text, if you want to use markdown, set the variable `WEBHOOK_TARGET_FORMAT` to `webex-markdown`
(or whatever additional template type you want to create).

## Extending

This implementation uses mustache templates to adapt from the EVA message format.  You can modify the existing templates
in the `src/main/resources/templates` folder.
