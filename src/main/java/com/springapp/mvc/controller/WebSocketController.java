package com.springapp.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * 长连接
 *
 * @auther f4o823hv9
 * @since  2017/7/12.
 */
@Controller
@ServerEndpoint("/websocket")
public class WebSocketController {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    @OnMessage
    public void onMessage(String mess, Session session) {
        logger.info("enter");
        for (int i = 0; i < 100; i++) {

            try {
                Thread.sleep(1000L);
                session.getBasicRemote().sendText("后台往前台传输东西" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
