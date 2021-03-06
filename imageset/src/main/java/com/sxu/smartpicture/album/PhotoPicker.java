package com.sxu.smartpicture.album;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;

/**
 * @author Freeman
 * @date 2017/12/14
 */


public class PhotoPicker {

	// 最多可选择的照片数量
	public final static String MAX_PHOTO_COUNT = "maxPhotoCount";
	// 已选择的照片列表
	public final static String SELECTED_PHOTOS = "selectedPhotos";
	// 是否显示照相机
	public final static String SHOW_CAMERA = "showCamera";
	// 相册列表的风格是否为列表样式
	public final static String PHOTO_LIST_STYLE_DIALOG = "styleIsDialog";

	private final static int DEFAULT_MAX_PHOTO_COUNT = 9;
	public final static int REQUEST_CODE_CHOOSE_PHOTO = 1000;

	private int mMaxPhotoCount;
	private ArrayList<String> mSelectedPhotos;
	private boolean mIsShowCamera;
	private boolean mIsDialog;

	private PhotoPicker(Builder builder) {
		this.mMaxPhotoCount = builder.mMaxPhotoCount;
		this.mSelectedPhotos = builder.mSelectedPhotos;
		this.mIsShowCamera = builder.mIsShowCamera;
		this.mIsDialog = builder.mIsDialog;
	}

	public void chooseImage(Activity context) {
		Intent intent = new Intent(context, ChoosePhotoActivity.class);
		intent.putExtra(MAX_PHOTO_COUNT, mMaxPhotoCount != 0 ? mMaxPhotoCount : DEFAULT_MAX_PHOTO_COUNT);
		intent.putExtra(SELECTED_PHOTOS, mSelectedPhotos);
		intent.putExtra(SHOW_CAMERA, mIsShowCamera);
		intent.putExtra(PHOTO_LIST_STYLE_DIALOG, mIsDialog);
		context.startActivityForResult(intent, REQUEST_CODE_CHOOSE_PHOTO);
	}

	public static class Builder{
		private int mMaxPhotoCount;
		private ArrayList<String> mSelectedPhotos;
		private boolean mIsShowCamera;
		private boolean mIsDialog;

		public Builder setMaxPhotoCount(int maxCount) {
			this.mMaxPhotoCount = maxCount;
			return this;
		}

		public Builder setSelectedPhotos(ArrayList<String> selectedPhotos) {
			this.mSelectedPhotos = selectedPhotos;
			return this;
		}

		public Builder setIsShowCamera(boolean showCamera) {
			this.mIsShowCamera = showCamera;
			return this;
		}

		public Builder setIsDialog(boolean isDalog) {
			this.mIsDialog = isDalog;
			return this;
		}

		public PhotoPicker builder() {
			return new PhotoPicker(this);
		}
	}
}
