/*
 * 	 This file is part of Find Your Friend.
 *
 *   Find Your Friend is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU Lesser General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   Find Your Friend is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with Find Your Friend.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.sgu.findyourfriend.model;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;


public class Friend {

	public static final int REQUEST_FRIEND = 0;
	public static final int REQUESTED_FRIEND = 1;
	public static final int FRIEND_RELATIONSHIP = 2;
	public static final int REQUEST_SHARE = 3;
	public static final int REQUESTED_SHARE = 4;
	public static final int SHARE_RELATIONSHIP = 5;
	
	// attribute
	private User userInfo;
	private ArrayList<String> numberLogin;
	private boolean isAvailable;
	private int acceptState;
	
	private int accurency = 15; // not available
	private LatLng lastLocation;
	private ArrayList<History> steps;
	
	private boolean check;

	public Friend(int id) {
		
		this.userInfo = new User(id);
	}
	
	public Friend(User userInfo, ArrayList<String> numberLogin, boolean isAvailable,
			int acceptState, LatLng lastLocation,
			ArrayList<History> steps) {
		super();
		this.userInfo = userInfo;
		this.numberLogin = numberLogin;
		this.isAvailable = isAvailable;
		this.acceptState = acceptState;
		this.lastLocation = lastLocation;
		this.steps = steps;
		this.setCheck(false);
	}

	public User getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(User userInfo) {
		this.userInfo = userInfo;
	}

	public ArrayList<String> getNumberLogin() {
		return numberLogin;
	}

	public void setNumberLogin(ArrayList<String> numberLogin) {
		this.numberLogin = numberLogin;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getAcceptState() {
		return acceptState;
	}

	public void setAcceptState(int acceptState) {
		this.acceptState = acceptState;
	}

	public LatLng getLastLocation() {
		return lastLocation;
	}

	public void setLastLocation(LatLng lastLocation) {
		this.lastLocation = lastLocation;
	}

	public ArrayList<History> getSteps() {
		return steps;
	}

	public void setSteps(ArrayList<History> steps) {
		this.steps = steps;
	}

	public int getAccurency() {
		return accurency;
	}
	
	public void setAccurency(int accurency) {
		this.accurency = accurency;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
}
