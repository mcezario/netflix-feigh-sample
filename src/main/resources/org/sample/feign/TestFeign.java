package org.sample.feign;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.sample.feigh.model.Contributor;
import org.sample.feigh.service.GitHub;

import feign.Feign;
import feign.gson.GsonDecoder;

public class TestFeign {

	@Test
	public void test() {
		GitHub github = Feign.builder().decoder(new GsonDecoder()).target(GitHub.class, "https://api.github.com");

		List<Contributor> contributors = github.contributors("OpenFeign", "feign");
		for (Contributor contributor : contributors) {
			System.out.println(contributor.getLogin() + " (" + contributor.getContributions() + ")");
		}
	}

}
