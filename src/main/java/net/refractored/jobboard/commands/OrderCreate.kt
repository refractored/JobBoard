package net.refractored.jobboard.commands

import net.refractored.jobboard.order.Order
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Description
import revxrsal.commands.bukkit.BukkitCommandActor
import revxrsal.commands.bukkit.annotation.CommandPermission


class OrderCreate {

    @CommandPermission("jobboard.player.create")
    @Description("Creates an order.")
    @Command("balls")
    fun orderCreate(actor: BukkitCommandActor, cost: Double) {
        if (actor.isConsole) {
            actor.error("You must be a player to use this command.")
            return
        }
        if (actor.asPlayer?.inventory?.itemInMainHand == null){
            actor.error("You must be holding an item to create an order.")
            return
        }
        val item = actor.asPlayer?.inventory?.itemInMainHand
        val order = Order()
        order.user = actor.uniqueId
        order.item = item?.serializeAsBytes()
        order.cost = cost
    }
}