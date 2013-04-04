package com.jinpinmei.manager;


import com.jinpinmei.JinpinmeiActivity;
import com.jinpinmei.R;
import com.jinpinmei.util.Constant;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class FontSizeMenu extends LinearLayout {

	JinpinmeiActivity ctx;
	SeekBar sb;
	TextView txt;
	Button btnPrev;
	Button btnNext;

	public FontSizeMenu(Context context) {
		super(context);
		ctx = (JinpinmeiActivity)context;
		// 初始化当前LinearLayout
		this.setGravity(Gravity.BOTTOM);
		
		final LayoutInflater inflater = LayoutInflater.from(ctx);
		// 给ImageView设置资源
		LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.percentdialog, null);
		
		sb = (SeekBar)layout.findViewById(R.id.seekBar1);
		txt = (TextView)layout.findViewById(R.id.textView1);
		btnPrev = (Button)layout.findViewById(R.id.btnPrev);
		btnNext = (Button)layout.findViewById(R.id.btnNext);
		
		sb.setMax(36);//最大值为48即36+12
		
		//sb.setProgress(GetSize()-12);
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				txt.setText("字体大小:" + (arg1 + 12));
				
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				int size = sb.getProgress();
				refreshText();
				updateSize(size + 12);
				ctx.SetFont(size + 12);
			}
		});
		
		btnPrev.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				int size = sb.getProgress();
				size--;
				sb.setProgress(size);
				refreshText();
				//ctx.SetFont(size + 12);
				updateSize(size + 12);
			}
		});
		btnNext.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				int size = sb.getProgress();
				size++;
				sb.setProgress(size);
				refreshText();
				updateSize(size + 12);
				//ctx.SetFont(size + 12);
			}
		});
		
		refreshText();
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
		layout.setBackgroundResource(R.drawable.box);
		layout.getBackground().setAlpha(240);
		layout.setGravity(Gravity.CENTER);
		params.setMargins(10, 10, 10, 10);
		this.addView(layout, params);
	}
	
	/**
	 * 将字体大小更新到数据库
	 * */
	private void updateSize(int size){
		SharedPreferences sp = getContext().getSharedPreferences(Constant.TXTSIZE, Context.MODE_WORLD_WRITEABLE);
		sp.edit().putInt(Constant.TXTSIZE, size).commit();
		//SetSize(size);
	}
	
	
	
	private void refreshText()
	{
		txt.setText("字体大小:" + (sb.getProgress() + 12));
	}
	
	public void SetSize(int size)
	{
		sb.setProgress(size - 12);
		refreshText();
	}
}

