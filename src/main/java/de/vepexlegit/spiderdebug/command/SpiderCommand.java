package de.vepexlegit.spiderdebug.command;

import de.vepexlegit.spiderdebug.Spider;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import java.util.Collections;
import java.util.List;

public class SpiderCommand implements ICommand {
    @Override
    public String getCommandName() {
        return "spider";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.emptyList();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length != 1 || (!args[0].equalsIgnoreCase("off") && !args[0].equalsIgnoreCase("on"))) {
            sender.addChatMessage(new ChatComponentText("Invalid Arguments."));
            return;
        }

        Spider.INSTANCE.setEnabled(args[0].equalsIgnoreCase("on"));

        sender.addChatMessage(new ChatComponentText(String.format("Spider has been %s.",
                Spider.INSTANCE.isEnabled() ? "enabled" : "disabled")));
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
