package org.quintilis.honras.types;

import org.bson.types.ObjectId;

import java.util.UUID;

public class ClanInvite {
	private final UUID sender;
	private final UUID receiver;
	private final ObjectId clanId;
	private final String clanName;
	private final long inviteTime;
	
	public ClanInvite(UUID sender, UUID receiver, ObjectId clanId,String clanName, long inviteTime) {
		this.sender = sender;
		this.receiver = receiver;
		this.clanId = clanId;
		this.clanName = clanName;
		this.inviteTime = inviteTime;
	}
	
	public UUID getSender() {
		return sender;
	}
	
	public UUID getReceiver() {
		return receiver;
	}
	
	public ObjectId getClanId() {
		return clanId;
	}
	
	public String getClanName() {
		return clanName;
	}
	
	public long getInviteTime() {
		return inviteTime;
	}
}
