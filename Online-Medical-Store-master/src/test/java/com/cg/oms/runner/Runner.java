package com.cg.oms.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = true, features = { "feature" }, glue = { "stepdef" })
public class Runner {

}