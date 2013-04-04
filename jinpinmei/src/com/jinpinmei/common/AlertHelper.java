package com.jinpinmei.common;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class AlertHelper {
	/*
	 * 弹出Alert框_Yes or No
	 */
	public static void AlertDialog_YesorNo(Context context, String title,
			String content, String Ok_Msg, String Cancel_Msg,
			OnClickListener finishListener) {
		new AlertDialog.Builder(context)
				.setTitle(title)
				.setMessage(content)
				.setPositiveButton(Ok_Msg,finishListener)
				.setNegativeButton(Cancel_Msg,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								dialog.dismiss();
							}
						}).show();
	}

	/*
	 * 弹出Alert框 确定
	 */
	public static void AlertDialog_Ok(Context context, String title,
			String content, String Ok_Msg) {
		new AlertDialog.Builder(context)
				.setTitle(title)
				.setMessage(content)
				.setPositiveButton(Ok_Msg,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								dialog.dismiss();
							}
						}).show();
	}

	public static void AlertDialog_List(Context context, String title,
			String[] listitem, OnClickListener ocl) {
		new AlertDialog.Builder(context).setTitle(title)
				.setItems(listitem, ocl)
				.show();
	}
}

