package edu.eci.arsw.springdemo;

import org.springframework.beans.factory.annotation.Autowired;


public class EnglishSpellChecker implements SpellChecker {
        @Autowired()
        
	@Override
	public String checkSpell(String text) {		
		return "Checked with english checker:"+text;
	}

        
}
