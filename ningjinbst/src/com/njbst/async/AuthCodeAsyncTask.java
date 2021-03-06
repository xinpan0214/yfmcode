package com.njbst.async;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import com.njbst.pro.R;
import com.njbst.utils.HttpUtils;
import com.njbst.utils.ToastUtils;
import com.njbst.utils.progressDialogUtils;

public class AuthCodeAsyncTask extends AsyncTask<String, Integer, JSONObject> {

	private progressDialogUtils pdu;
	private Context context;
	private Handler handler;

	public AuthCodeAsyncTask(Context context, Handler handler) {
		this.context = context;
		pdu = new progressDialogUtils(context, this);
		this.handler = handler;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		pdu.showPd(R.string.loading);
	}

	@Override
	protected void onPostExecute(JSONObject jo) {
		// TODO Auto-generated method stub
		super.onPostExecute(jo);
		pdu.closePd();
		try {
			if (jo != null) {

				if (jo.getBoolean("state")) {
					Message msg = handler.obtainMessage();
					msg.what = 2;
					msg.arg1 = jo.getInt("userid");
					handler.sendMessage(msg);
				}
				ToastUtils.showToast(context, jo.getString("msg"));
				return;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ToastUtils.showToast(context, R.string.server_error);
	}

	@Override
	protected JSONObject doInBackground(String... params) {
		// TODO Auto-generated method stub
		JSONObject jo = null;
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("a", "resetpwdcode"));
		nvps.add(new BasicNameValuePair("phonenum", params[0]));
		nvps.add(new BasicNameValuePair("code", params[1]));
		String result = HttpUtils.DoPost(HttpUtils.baseUrl, nvps);
		if (result != null) {
			try {
				jo = new JSONObject(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jo;
	}

}
