package com.example.chansiqing.databindingstudy.floors.floor;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.data.AnnouncementData;
import com.example.chansiqing.databindingstudy.floors.floorCommonInterface.FloorMatchDataInterface;
import com.example.chansiqing.databindingstudy.utils.UIUtil;
import com.example.chansiqing.databindingstudy.view.BabelSingleFlipperView;
import com.example.chansiqing.databindingstudy.view.SpecSimpleDrawee;

import java.util.ArrayList;
import java.util.List;


/**
 * 新人权益楼层
 *
 * @author: chansiqing
 * @date: 2019-03-11 15:07
 */
public class BabelNewsRightsView extends RelativeLayout implements FloorMatchDataInterface {
    private BabelSingleFlipperView singleFlipperView;
    private List<AnnouncementData> announcement;
    private int count, currentIndex;
    private static final int LAYOUT_HEIGHT = UIUtil.dp2px(30);

    public BabelNewsRightsView(Context context) {
        super(context);
        initView();
    }

    public BabelNewsRightsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public void initView() {
        singleFlipperView = new BabelSingleFlipperView(getContext());
        singleFlipperView.setPadding(0, LAYOUT_HEIGHT, 0, 0);
        RelativeLayout.LayoutParams layoutParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 4 * LAYOUT_HEIGHT);
        layoutParam.addRule(CENTER_VERTICAL);
        singleFlipperView.setOrientation(LinearLayout.VERTICAL);
        singleFlipperView.setLayoutParams(layoutParam);
        singleFlipperView.setLayoutHeight(LAYOUT_HEIGHT);
        List<NewRightsFlipperInnerView> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            final NewRightsFlipperInnerView view = new NewRightsFlipperInnerView(getContext());
            final int finalI = i;
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("click_witch", "view_" + finalI + view.getData().getAdText());
                }
            });
            list.add(view);
        }
        singleFlipperView.addLayout(list.get(0));
        singleFlipperView.addLayout(list.get(1));
        singleFlipperView.setListener(new BabelSingleFlipperView.OnAnimOnceFinishedListener() {
            @Override
            public void onFinish(ViewGroup viewGroup) {
                if (viewGroup instanceof NewRightsFlipperInnerView) {
                    NewRightsFlipperInnerView innerView = (NewRightsFlipperInnerView) viewGroup;
                    currentIndex = (currentIndex + 1) % count;
                    if (announcement != null) {
                        innerView.updateUI(announcement.get(currentIndex));
                    }
                }
            }
        });
        addView(singleFlipperView);
    }


    @Override
    public void adapterData(Object data) {
        if (data instanceof ArrayList) {
            announcement = (List<AnnouncementData>) data;
            count = announcement.size();
            currentIndex = 1;
            List<ViewGroup> views = singleFlipperView.getViews();
            if (views == null) return;
            for (int i = 0; i < views.size(); i++) {
                ViewGroup viewGroup = views.get(i);
                if (viewGroup instanceof NewRightsFlipperInnerView) {
                    NewRightsFlipperInnerView innerView = (NewRightsFlipperInnerView) viewGroup;
                    innerView.updateUI(announcement.get(i));
                }
            }
            singleFlipperView.startAnim();
        }
    }

    @Override
    public int getFloorHeight() {
        return UIUtil.dp2px(120);
    }

    public class NewRightsFlipperInnerView extends RelativeLayout {
        private SpecSimpleDrawee iconSv;
        private TextView adTv;
        private TextView operateTv;
        private AnnouncementData data;

        public AnnouncementData getData() {
            return data;
        }

        public NewRightsFlipperInnerView(Context context) {
            super(context);
            init();
        }

        public NewRightsFlipperInnerView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        private void init() {
            View view = LayoutInflater.from(this.getContext()).inflate(R.layout.babel_view_new_rights_flipper_inner, this);
            iconSv = view.findViewById(R.id.icon_sv);
            adTv = view.findViewById(R.id.ad_tv);
            operateTv = view.findViewById(R.id.operate_tv);
        }

        public void updateUI(AnnouncementData data) {
            if (data == null) return;
            this.data = data;
            iconSv.setImageURI(data.getUrl());
            operateTv.setText(data.getOperateText());
            adTv.setText(data.getAdText());
        }
    }
}
