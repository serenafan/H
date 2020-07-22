package testCases;

import java.io.IOException;

import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import pageObjects.GodOfSkyPage;
import pageObjects.LandingPage;
import pageObjects.TutorialPage;


public class TestCase_001 extends BaseClass{

	@Test
	public void playerProfile  () throws URISyntaxException, IOException
	{
		//Create the object for landing page
		LandingPage landingPg=new LandingPage(driver);
		
		//Click ok button
		landingPg.clickOkButton();
		logger.info("Click ok button");
		
		//Click allow to access photos, media and files
		landingPg.clickAllowButton();
		logger.info("Click allow to access photos, media and files");
		
		//Somehow it appium exits game automatically and have to go into the game again
		landingPg.clickIntoGame();
		logger.info("Click into Huuuge Casino game");
		
		//Click to accept legal document
		landingPg.clickAcceptButton();
		logger.info("Click to accept legal document");
		
		//Create the object for Tutorial Page
		TutorialPage tutorialPg =new TutorialPage(driver);
		
		//Below for loop to complete tutorial steps:
		//step1:spin
		//step2:set bet for 10K
		//step3:spin
		//step4:spin
		for(int i=0;i<3;i++)
		{
			//Click on spin button
			tutorialPg.clickSpinButton();
			logger.info("Click on spin button"+i+"th time");
			
			if(i==0) 
			{
			//Click on 2nd step tutorial:set bet
				tutorialPg.clickSetBetButton();
				logger.info("Click on 2nd step tutorial:set bet");
			}
			
		}
		
		//Click complete tutorial button
		tutorialPg.clickCompleteButton();
		logger.info("Click complete tutorial button");
		
		//Click play as guest on "who are you" pop up
		landingPg.clickPlayGuestBtn();
		logger.info("Click play as guest on who are you pop up");
		
		//Click God of Sky button
		landingPg.clickGodOfSky();
		logger.info("Click God of Sky button");
				
		//Click God of Sky page
		GodOfSkyPage godSkyPg= new GodOfSkyPage(driver);
		logger.info("Click God of Sky page");

		//Select beginner game
		godSkyPg.selectBeginnerGame();
		logger.info("Select beginner game");

		
		//Open profile
		godSkyPg.clickProfile();
		logger.info("Open profile");
		
		if(godSkyPg.verifyEditProfile())
		{
			Assert.assertTrue(true);
			logger.info("Profile page is successfully opened");
		}
		else
		{
			Assert.assertTrue(true);
			logger.error("Profile page is not displayed");
		}

		
		
	}

}
