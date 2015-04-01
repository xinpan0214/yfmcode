package com.iptv.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;


public class PlayThread extends Thread{

	private Handler handler;
	private String url;
	private HttpUtils hu;
	private boolean isqh=true;
	public PlayThread(Handler handler,String url){
		this.handler=handler;
		this.url=url;
		hu=new HttpUtils();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			sendmsg(1,"�����л��� ");
			Log.i("tvinfo", url);
			String xml=hu.doget(url,2000,3000);
			Log.i("tvinfo", xml);
			if(xml!=null&&isqh){
				sendmsg(2,"��ʼ����");
				boolean isflag=hu.sendrequest(url);
				if(isqh&&isflag){
					sendmsg(3,"��ʼ���� ");
				}else{
					sendmsg(4,"����ʧ�� ");
				}
			}else{
				sendmsg(4,"�л�ʧ�� ");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close(){
		isqh=false;
	}
	public void sendmsg(int i,String message){
		Message msg=handler.obtainMessage();
		msg.what=i;
		msg.obj=message;
		handler.sendMessage(msg);
	}
	
}