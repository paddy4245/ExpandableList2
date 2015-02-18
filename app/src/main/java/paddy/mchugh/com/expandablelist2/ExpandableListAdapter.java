package paddy.mchugh.com.expandablelist2;


        import java.util.HashMap;
        import java.util.List;

        import android.content.Context;
        import android.graphics.Color;
        import android.graphics.Typeface;
        import android.text.Spannable;
        import android.text.SpannableString;
        import android.text.SpannableStringBuilder;
        import android.text.method.LinkMovementMethod;
        import android.text.style.ForegroundColorSpan;
        import android.text.style.RelativeSizeSpan;
        import android.text.style.StyleSpan;
        import android.text.style.URLSpan;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseExpandableListAdapter;
        import android.widget.ExpandableListView;
        import android.widget.ImageView;
        import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }



    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {



        final String childText = (String) getChild(groupPosition, childPosition);


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }



        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);

        txtListChild.setText(childText);
        //txtListChild.setTypeface(null, Typeface.BOLD);

        if (childText.equalsIgnoreCase("Mangan Coaches")){
            String title = "Mangan Coaches";
            String desc = "Falcarragh-Letterkenny Daily";
            Log.i("title length", String.valueOf(title.length()));
            Log.i("desc length", String.valueOf(desc.length()));

            SpannableString styledString = new SpannableString(title + System.getProperty("line.separator") + desc);
            styledString.setSpan(new StyleSpan(Typeface.NORMAL), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            styledString.setSpan(new StyleSpan(Typeface.ITALIC), title.length() + 1, title.length() + desc.length(), 0);
            styledString.setSpan(new RelativeSizeSpan(0.8f), title.length() + 1, title.length() + desc.length() + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            txtListChild.setText(styledString);

        }
        if (childText.equalsIgnoreCase("John McGinley Coaches")){
            String title = "John McGinley Coaches";
            String desc = "Donegal-Dublin Daily";
            Log.i("title length", String.valueOf(title.length()));
            Log.i("desc length", String.valueOf(desc.length()));

            SpannableString styledString = new SpannableString(title + System.getProperty("line.separator") + desc);
            styledString.setSpan(new StyleSpan(Typeface.NORMAL), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            styledString.setSpan(new StyleSpan(Typeface.ITALIC), title.length() + 1, title.length() + desc.length(), 0);
            styledString.setSpan(new RelativeSizeSpan(0.8f), title.length() + 1, title.length() + desc.length() + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            txtListChild.setText(styledString);

        }

        if (childText.equalsIgnoreCase("PR Cabs")){
            convertView.setFocusable(false);
            String title = "PR Cabs";
            String desc = "555 555";
            Log.i("title length", String.valueOf(title.length()));
            Log.i("desc length", String.valueOf(desc.length()));

            SpannableString styledString = new SpannableString(title + System.getProperty("line.separator") + desc);
            styledString.setSpan(new StyleSpan(Typeface.NORMAL), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            styledString.setSpan(new StyleSpan(Typeface.ITALIC), title.length() + 1, title.length() + desc.length(), 0);
            styledString.setSpan(new URLSpan("tel:555 555"), title.length() + 1, title.length() + desc.length() + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            txtListChild.setText(styledString);
            txtListChild.setMovementMethod(LinkMovementMethod.getInstance());

        }


        ImageView imgViewChild = (ImageView) convertView.findViewById(R.id.imageView);
        if (childText.equalsIgnoreCase("The Cloughaneely Stone")) {
            imgViewChild.setImageResource(R.drawable.cloughaneely_stone_small);
        }
        if (childText.equalsIgnoreCase("Tullaghobegley Graveyard")) {
            imgViewChild.setImageResource(R.drawable.tullaghobegley_small);
        }
        if (childText.equalsIgnoreCase("Ballyconnell House")) {
            imgViewChild.setImageResource(R.drawable.ballyconnell_house_small);
        }
        if (childText.equalsIgnoreCase("Ray Church")) {
            imgViewChild.setImageResource(R.drawable.ray_church_small);
        }
        if (childText.equalsIgnoreCase("Bridge of Tears")) {
            imgViewChild.setImageResource(R.drawable.bridge_of_tears_small);
        }
        if (childText.equalsIgnoreCase("Begley\'s Kneeling Stone")) {
            imgViewChild.setImageResource(R.drawable.begleys_kneeling_stone_small);
        }
        if (childText.equalsIgnoreCase("Portal Dolmen")) {
            imgViewChild.setImageResource(R.drawable.portal_dolmen_small);
        }
        if (childText.equalsIgnoreCase("Home of Micí Mac Gabhann")) {
            imgViewChild.setImageResource(R.drawable.teach_mici_mac_gabhann_small);
        }
        if (childText.equalsIgnoreCase("Castle Bawne")) {
            imgViewChild.setImageResource(R.drawable.castle_bawne_small);
        }

        if(childText.equalsIgnoreCase("Ards Forest Park")){
            imgViewChild.setImageResource(R.drawable.ards);
        }
        if(childText.equalsIgnoreCase("Glenveagh National Park")){
            imgViewChild.setImageResource(R.drawable.glenveagh);
        }

        // TAXI icons
        if (childText.equalsIgnoreCase("PR Cabs") ||
                childText.equalsIgnoreCase("Sweeney\'s Taxi") ||
                childText.equalsIgnoreCase("Fast Cabs")  ) {
            imgViewChild.setImageResource(R.drawable.taxi_icon);
        }

        // BUS icons
        if (childText.equalsIgnoreCase("Mangan Coaches") ||
                childText.equalsIgnoreCase("John McGinley Coaches") ||
                childText.equalsIgnoreCase("Bus Feda") ||
                childText.equalsIgnoreCase("Patrick Gallagher"))  {
            imgViewChild.setImageResource(R.drawable.bus_icon);
        }



        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }



    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }



    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
