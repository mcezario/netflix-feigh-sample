package org.sample.feigh.service;

import java.util.List;

import org.sample.feigh.model.Contributor;

import feign.Param;
import feign.RequestLine;

interface GitHub {
	
	@RequestLine("GET /repos/{owner}/{repo}/contributors")
	List<Contributor> contributors(@Param("owner") String owner,
			@Param("repo") String repo);
	
	
}
