package net.refractored.jobboard.commands

import net.refractored.jobboard.order.Order
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Description
import revxrsal.commands.bukkit.BukkitCommandActor
import revxrsal.commands.bukkit.annotation.CommandPermission

class OrderCreate {
    @CommandPermission("jobboard.player.create")
    @Description("Creates an order.")
    @Command("order create")
    fun matchCreate(actor: BukkitCommandActor, cost: Double) {
        if (actor.isConsole) {
            actor.error("You must be a player to use this command.")
            return
        }
        val item = actor.asPlayer?.inventory?.itemInMainHand
        val order = Order()
        order.user = actor.uniqueId
        order.item = item
        order.cost = cost
    }
}