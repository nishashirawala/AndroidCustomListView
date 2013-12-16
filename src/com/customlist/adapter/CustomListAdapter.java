package com.customlist.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.customlist.customlistview.R;

public class CustomListAdapter extends BaseAdapter {
	private List<ListVO> data = new ArrayList<ListVO>();
	private static LayoutInflater inflater = null;

	private static final String NO_SERVICE = "No Service";

	public CustomListAdapter(Activity activity, List<ListVO> listVO) {
		this.data = listVO;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (data.size() > 0) {
			View vi = convertView;
			if (convertView == null)
				vi = inflater.inflate(R.layout.route_time_list_view, null);

			TextView mainText = (TextView) vi.findViewById(R.id.mainString);
			TextView smallText1 = (TextView) vi.findViewById(R.id.smallText1);
			TextView smallText2 = (TextView) vi.findViewById(R.id.smallText2);
			TextView smallText3 = (TextView) vi.findViewById(R.id.smallText3);
			TextView smallText4 = (TextView) vi.findViewById(R.id.smallText4);
			TextView smallText5 = (TextView) vi.findViewById(R.id.smallText5);
			
			mainText.setText("");
			smallText1.setText("");
			smallText2.setText("");
			smallText3.setText("");
			smallText4.setText("");
			smallText5.setText("");

			LinearLayout divider1 = (LinearLayout) vi
					.findViewById(R.id.divider1);
			LinearLayout divider2 = (LinearLayout) vi
					.findViewById(R.id.divider2);
			LinearLayout divider3 = (LinearLayout) vi
					.findViewById(R.id.divider3);
			LinearLayout divider4 = (LinearLayout) vi
					.findViewById(R.id.divider4);
			
			divider1.setVisibility(4);
			divider2.setVisibility(4);
			divider3.setVisibility(4);
			divider4.setVisibility(4);

			if (data != null && data.size() > 0) {
				ListVO listVO = data.get(position);
				String routeName = listVO.getRouteName();
				mainText.setText(routeName);
				if (!NO_SERVICE.equals(routeName)) {
					List<String> timeList = listVO.getTimeList();
					for (int index = 0; index < timeList.size(); index++) {
						String time = timeList.get(index);
						Integer indexObj = index;
						switch (indexObj) {
						case 0:
							smallText1.setText(time);
							break;
						case 1:
							smallText2.setText(time);
							divider1.setVisibility(0);
							break;
						case 2:
							smallText3.setText(time);
							divider2.setVisibility(0);
							break;
						case 3:
							smallText4.setText(time);
							divider3.setVisibility(0);
							break;
						case 4:
							smallText5.setText(time);
							divider4.setVisibility(0);
							break;
						default:
							System.out.println("this should not happen");
						}
					}
				}
			}
			return vi;
		}
		return null;
	}

}
