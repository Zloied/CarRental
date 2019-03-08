package com.vais.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vais.entities.Feedback;
import com.vais.repositories.FeedBackRepository;
import com.vais.utils.UserDetail;

@Controller
@Transactional
@SessionAttributes({ "role", "name" })
public class FeedbackController {

	@Autowired
	FeedBackRepository feedBackRepository;

	/**
	 * adds new feedback from authorized user into the database through DAO layer
	 * call
	 * 
	 * @param model   Spring ModelMap class used to put and get parameters from
	 *                session
	 * @param rate    feedback score from request
	 * @param comment feedback text from request
	 * @return redirection to appropriate page
	 */
	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	public String addFeedback(Principal principal, @RequestParam(defaultValue = "0") int rate,
			@RequestParam(defaultValue = "") String comment) {

		String name = ((UserDetail) ((Authentication) principal).getPrincipal()).getUsername();

		if ((rate != 0) && (comment != "")) {
			feedBackRepository.addFeedback(new Feedback(comment, rate, name));
		}
		return "redirect:/userHome";
	}

	/**
	 * Retrieves all feedbacks from database and puts them into model
	 * 
	 * @param model used to put data into response
	 * @return redirect jsp page
	 */
	@RequestMapping(value = "/feedback", method = RequestMethod.GET)
	public String getFeedback(Model model) {
		model.addAttribute("feedbacks", feedBackRepository.getFeedbacks());
		return "feedback";
	}
}
