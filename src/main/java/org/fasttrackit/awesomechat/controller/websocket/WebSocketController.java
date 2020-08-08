package org.fasttrackit.awesomechat.controller.websocket;

import org.springframework.web.bind.annotation.RequestMapping;

public class WebSocketController {
    @RequestMapping("/websocket")
    public String getWebSocket() {
        return "ws-broadcast";
    }
}
