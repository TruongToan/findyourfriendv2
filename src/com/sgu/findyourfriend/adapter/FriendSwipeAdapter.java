package com.sgu.findyourfriend.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.sgu.findyourfriend.R;
import com.sgu.findyourfriend.model.Friend;

public class FriendSwipeAdapter extends ArrayAdapter<Friend> {
	int LayoutResID;
	Context ctx;
	List<Friend> DataList = new ArrayList<Friend>();
	ImageLoader imageLoader;
	DisplayImageOptions options;
	private int itemIdHightLight = -1;

	@SuppressWarnings("deprecation")
	public FriendSwipeAdapter(Context context, int resource,
			List<Friend> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		ctx = context;
		LayoutResID = resource;
		DataList = objects;

		options = new DisplayImageOptions.Builder().cacheInMemory(true)
				.cacheOnDisc(true).considerExifParams(true)
				.bitmapConfig(Bitmap.Config.RGB_565).build();
		imageLoader = ImageLoader.getInstance();
//		File cacheDir = StorageUtils.getCacheDirectory(context);
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context)
				.memoryCacheExtraOptions(480, 800)
				// default = device screen dimensions

				.taskExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
				.taskExecutorForCachedImages(AsyncTask.THREAD_POOL_EXECUTOR)
				.threadPoolSize(3)
				// default
				.threadPriority(Thread.NORM_PRIORITY - 1)
				// default
				.tasksProcessingOrder(QueueProcessingType.FIFO)
				// default
				.denyCacheImageMultipleSizesInMemory()
				.memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
				// default
				.memoryCacheSize(2 * 1024 * 1024)
				.imageDownloader(new BaseImageDownloader(context)) // default
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
				.build();
		imageLoader.init(config);
	}

	public void hightLightItem(int pos) {
		itemIdHightLight = pos;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Friend friend = this.getItem(position);

		convertView = LayoutInflater.from(ctx).inflate(LayoutResID, parent, false);
		ImageView imgAvatar = (ImageView) convertView
				.findViewById(R.id.imgAvatar);

		imageLoader.displayImage(friend.getUserInfo().getAvatar(), imgAvatar);

		if (itemIdHightLight == position) 
			convertView.setBackgroundColor(0xff086EBC);
		
		return convertView;
	}

}
