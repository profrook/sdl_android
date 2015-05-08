package com.smartdevicelink.proxy;

import com.smartdevicelink.proxy.rpc.enums.Result;

public abstract class OnUpdateListener {
	long totalSize = 0;
	/**
	 * This method will be called once the packet has been entered into the queue of messages to send
	 * @param correlationId
	 * @param totalSize
	 */
	public void onStart(int correlationId, long totalSize){
		
	};
	/**
	 * onUpdate will only be called if a packet is a multiframed packet.
	 * @param correlationId
	 * @param bytesWrote
	 * @param totalSize
	 */
	public void onUpdate(int correlationId, long bytesWritten, long totalSize){
		
	};
	/**
	 * This is the only method that must be extended. Other methods that are able to be extended are 
	 * onStart, onUpdated, and onError.
	 * @param correlationId
	 * @param message This will be the response message received from the core side. It should be cast into a corresponding RPC Response type. ie, if setting this
	 * for a PutFile request, the message parameter should be cast to a PutFileResponse class.
	 * @param totalSize
	 */
	public abstract void onFinish(int correlationId, final RPCMessage message, long totalSize);
	
	public void onError(int correlationId, Result resultCode, String info){
		
	};
	
	protected void setTotalSize(long totalSize){
		this.totalSize = totalSize;
	}
	
}