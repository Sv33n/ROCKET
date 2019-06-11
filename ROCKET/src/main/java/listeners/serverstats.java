package listeners;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class serverstats extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        event.getGuild().getTextChannelById("587902277474320385").ed

    }
}
