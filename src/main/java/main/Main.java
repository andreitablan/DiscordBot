package main;

import botConfiguration.DiscordBot;
import com.sun.syndication.io.FeedException;
import dataBase.AnswersRepository;

import javax.security.auth.login.LoginException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws LoginException, InterruptedException, IOException, FeedException, TransformerException {
        AnswersRepository answersRepository = new AnswersRepository();
        new DiscordBot().run();
    }
}
