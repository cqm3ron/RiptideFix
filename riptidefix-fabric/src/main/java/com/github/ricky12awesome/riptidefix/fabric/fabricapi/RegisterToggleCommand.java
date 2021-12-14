package com.github.ricky12awesome.riptidefix.fabric.fabricapi;

import com.github.ricky12awesome.riptidefix.fabric.RiptideFixClient;
import com.mojang.brigadier.Command;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;

public class RegisterToggleCommand {
    public static void Register() {
        Command<FabricClientCommandSource> executes = context -> {
            RiptideFixClient.ENABLED = !RiptideFixClient.ENABLED;

            var enabledText = RiptideFixClient.ENABLED ? "enabled" : "disabled";
            var color = RiptideFixClient.ENABLED ? Formatting.GREEN : Formatting.RED;
            var style = Style.EMPTY.withFormatting(color);
            var preStyle = Style.EMPTY.withFormatting(Formatting.GRAY);
            var text = new LiteralText(enabledText).setStyle(style);
            var message = new LiteralText("RiptideFix has been ")
                    .setStyle(preStyle)
                    .append(text);

            context.getSource().sendFeedback(message);

            return 0;
        };

        var command = ClientCommandManager
                .literal("riptidefix_toggle")
                .executes(executes);

        ClientCommandManager.DISPATCHER.register(command);
    }
}
