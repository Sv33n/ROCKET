package core;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import util.STATIC;

import java.util.Arrays;

public class kickperms {
    public static boolean check (MessageReceivedEvent event) {

        for ( Role r : event.getGuild().getMember(event.getAuthor()).getRoles() ) {

            if (Arrays.stream(STATIC.PERMISSION).parallel().anyMatch(r.getName():: contains))
                return false;


        }
        return true;

    }

}


