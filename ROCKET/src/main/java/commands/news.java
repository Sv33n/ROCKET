package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.managers.GuildController;

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class news implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        String now = new SimpleDateFormat(" HH:mm:ss, dd.MM.yyyy").format(new Date());


        Guild guild = event.getGuild();
        GuildController guildcon = new GuildController(event.getGuild());

        MessageChannel channel = event.getChannel();


        EmbedBuilder embed = new EmbedBuilder().setColor(Color.red);

        if (core.kickperms.check(event)) {
            channel.sendMessage(
                    embed.setDescription(":warning: Sorry, " + event.getAuthor().getAsMention() + " you do not have the necessary permissions to run this command!").build()).queue();
            return; }


        String msg = String.join(" ", args);
        User author = event.getMessage().getAuthor();


        event.getMessage().delete().queue();

        event.getGuild().getTextChannelById("566326295244308483").sendMessage(new EmbedBuilder()
                .setColor(new Color(255, 89, 14))
                .setAuthor(author.getName(), null, author.getAvatarUrl())
                .setDescription(msg)
                .setFooter("Date: " + now )
                .build()
        ).queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }

    private void send(String msg, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(msg).queue();
    }
}