package com.example.hackathon;

import java.util.List;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;



public class MySampleFragment extends Fragment {
	 private static View mView;
	 List<ParseObject> pol;
	 
	    public static final MySampleFragment newInstance(String sampleText) {
	        MySampleFragment f = new MySampleFragment();
	        
	        Bundle b = new Bundle();
	        f.setArguments(b);

	    return f;
	    }
	    
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

	        mView = inflater.inflate(R.layout.fragment, container, false);
	      //  Parse.initialize(mView.getContext(), "e0FVFRBMAWJi5shg4XF8zL3SIuRwDIufww3338so", "toTJmlHTEF43u7PoAFT4fedwqfhoWiSajj1Se7FT");
			ParseUser currentUser = ParseUser.getCurrentUser();
			
			ParseQuery<ParseObject> query4 = new ParseQuery<ParseObject>("AddDoctor");
			 query4.whereEqualTo("patient_id",currentUser.getObjectId());
			 
			 try{
				pol=query4.find(); 
			 }
			 catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
			 for(ParseObject t : pol)
			 {
				 if(t.get("Constituency")==currentUser.get("Place"))
						 {
						 }
			 }
	    
	    return mView;
}
}