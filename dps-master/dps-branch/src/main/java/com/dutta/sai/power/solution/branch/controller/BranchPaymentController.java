
package com.dutta.sai.power.solution.branch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dutta.sai.power.solution.branch.service.impl.BranchPaymentServiceImpl;

@RestController
public class BranchPaymentController {

	@Autowired
	private BranchPaymentServiceImpl service;

}
