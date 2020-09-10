package dev.demeng.grantx.api;

import org.bukkit.OfflinePlayer;

public final class Grant {

  private final int id;

  private final long activationTime;
  private final Status status;
  private final boolean permissionGrant;

  private final OfflinePlayer target;
  private final OfflinePlayer issuer;
  private final OfflinePlayer revoker;

  private final String rank;
  private final String server;
  private final long duration;
  private final String reason;

  private final long revocationTime;

  public Grant(
      int id,
      long activationTime,
      Status status,
      boolean permissionGrant,
      OfflinePlayer target,
      OfflinePlayer issuer,
      OfflinePlayer revoker,
      String rank,
      String server,
      long duration,
      String reason,
      long revocationTime) {
    this.id = id;
    this.status = status;
    this.activationTime = activationTime;
    this.permissionGrant = permissionGrant;
    this.target = target;
    this.issuer = issuer;
    this.revoker = revoker;
    this.rank = rank;
    this.server = server;
    this.duration = duration;
    this.reason = reason;
    this.revocationTime = revocationTime;
  }

  /**
   * The unique numeric identifier of the grant.
   *
   * @return The ID of the grant.
   */
  public int getId() {
    return id;
  }

  /**
   * The Unix Epoch time of when this grant was activated.
   *
   * @return Time of when the grant was activated, or -1 if the grant is not active
   */
  public long getActivationTime() {
    return activationTime;
  }

  /**
   * The current status of the grant- may be null/outdated during pre- events.
   *
   * @return The current status of the grant.
   */
  public Status getStatus() {
    return status;
  }

  /**
   * If this grant is an actual rank grant or a permission grant.
   *
   * @return True if this is a permission node grant, false if this is a rank/group grant.
   */
  public boolean isPermissionGrant() {
    return permissionGrant;
  }

  /**
   * The target of the grant.
   *
   * @return The target of the grant.
   */
  public OfflinePlayer getTarget() {
    return target;
  }

  /**
   * The issuer of the grant.
   *
   * @return The issuer of the grant, or null if the grant was activated by console.
   */
  public OfflinePlayer getIssuer() {
    return issuer;
  }

  /**
   * The revoker of the grant.
   *
   * @return The revoker of the grant, or null if the grant is not revoked.
   */
  public OfflinePlayer getRevoker() {
    return revoker;
  }

  /**
   * The "real name" of the rank- should be either a permission group name or a permisson node. Use
   * {@link #isPermissionGrant()} to determine if this is a group or a node.
   *
   * @return The group or permission node of the rank (real name).
   */
  public String getRank() {
    return rank;
  }

  /**
   * The targetted server of the grant.
   *
   * @return The real name of the server.
   */
  public String getServer() {
    return server;
  }

  /**
   * The duration of the grant.
   *
   * @return The number of seconds the duration lasts, or -1 if permanent.
   */
  public long getDuration() {
    return duration;
  }

  /**
   * The reason of the grant.
   *
   * @return The display name of the reason of the grant.
   */
  public String getReason() {
    return reason;
  }

  /**
   * The Unix Epoch time of when this grant was revoked.
   *
   * @return Time of when the grant was revoked, or -1 if the grant is not revoked
   */
  public long getRevocationTime() {
    return revocationTime;
  }

  /** Possible statuses for a grant. */
  public enum Status {
    ACTIVE,
    EXPIRED,
    REVOKED
  }
}
