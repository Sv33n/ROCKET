package listeners;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;



public class userjoinserverlistener extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        try {

            event.getGuild().getTextChannelsByName("write", true).get(0).sendMessage(
                   "Hey " +
                                    event.getMember().getUser().getAsMention() + "! :wave: Welcome on " + "**LOST ROCKET**! " + "Feel like home..."

            ).queue();

        } catch (Exception e) {
            System.out.println("ERROR on Guild " + event.getGuild().getName());
        }
        Role role = event.getGuild().getRoleById("587682934635495435");
        event.getGuild().getController().addSingleRoleToMember(event.getMember(), role).queue();


    }

}