package com.utng.Singleton.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.utng.Singleton.model.ChatMessage;

@Controller
public class ChatController {

	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage registrar(@Payload ChatMessage respuesta, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", respuesta.getSender());
		return respuesta;
	}
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage enviarRespuesta(@Payload ChatMessage respuesta) {
		return respuesta;
	}
	
	@GetMapping("/detalles/{nomDebate}")
	public String consultarPorId(@PathVariable("nomDebate") String nomDebate, 
			@PathVariable("nomDebate") String nomTema1,
			@PathVariable("nomDebate") String nomTema2,
			@PathVariable("nomDebate") String nomTema3) {

		return "detalle_tema";
	}
}
