package core;


import commands.news;
import listeners.commandListener;
import listeners.userjoinserverlistener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import util.SECRETS;
import util.STATIC;

import javax.security.auth.login.LoginException;

import static util.STATIC.Game;


public class Main {
    public static JDABuilder builder;

    public static void main(String[] Args) {


        builder = new JDABuilder(AccountType.BOT)
        .setToken(SECRETS.TOKEN)
        .setAutoReconnect(true)
        .setStatus(OnlineStatus.valueOf("DO_NOT_DISTURB"));




        builder.addEventListeners(new userjoinserverlistener());
        builder.addEventListeners(new commandListener());
        commandHandler.commands.put("say", new news());


        try {
            JDA jda = builder.build();
            jda.getPresence().setActivity(Activity.watching("the Earth..."));

        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}