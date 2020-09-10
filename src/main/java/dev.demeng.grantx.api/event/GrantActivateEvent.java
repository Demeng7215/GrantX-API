package dev.demeng.grantx.api.event;

import dev.demeng.grantx.api.Grant;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/** Event called once GrantX has completed processing grant activation. */
public final class GrantActivateEvent extends Event {

  private static final HandlerList handlers = new HandlerList();

  private final Grant grant;

  public GrantActivateEvent(Grant grant) {
    this.grant = grant;
  }

  public Grant getGrant() {
    return grant;
  }

  @Override
  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }
}
