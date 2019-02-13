package com.example.chansiqing.databindingstudy.databinding;
import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainFrameBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rotate, 5);
    }
    // views
    @NonNull
    public final android.widget.Button btn1;
    @NonNull
    public final android.widget.Button btn2;
    @NonNull
    public final android.widget.Button btn3;
    @NonNull
    public final android.widget.Button btn4;
    @NonNull
    public final android.widget.RelativeLayout root;
    @NonNull
    public final android.widget.ImageView rotate;
    // variables
    @Nullable
    private com.example.chansiqing.databindingstudy.data.MainFrameData mItem;
    @Nullable
    private com.example.chansiqing.databindingstudy.viewModel.MainFramePresenter mPresenter;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    private OnClickListenerImpl mPresenterOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ActivityMainFrameBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.btn1 = (android.widget.Button) bindings[1];
        this.btn1.setTag(null);
        this.btn2 = (android.widget.Button) bindings[2];
        this.btn2.setTag(null);
        this.btn3 = (android.widget.Button) bindings[3];
        this.btn3.setTag(null);
        this.btn4 = (android.widget.Button) bindings[4];
        this.btn4.setTag(null);
        this.root = (android.widget.RelativeLayout) bindings[0];
        this.root.setTag(null);
        this.rotate = (android.widget.ImageView) bindings[5];
        setRootTag(root);
        // listeners
        mCallback2 = new android.databinding.generated.callback.OnClickListener(this, 2);
        mCallback1 = new android.databinding.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.item == variableId) {
            setItem((com.example.chansiqing.databindingstudy.data.MainFrameData) variable);
        }
        else if (BR.presenter == variableId) {
            setPresenter((com.example.chansiqing.databindingstudy.viewModel.MainFramePresenter) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.example.chansiqing.databindingstudy.data.MainFrameData Item) {
        updateRegistration(0, Item);
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    @Nullable
    public com.example.chansiqing.databindingstudy.data.MainFrameData getItem() {
        return mItem;
    }
    public void setPresenter(@Nullable com.example.chansiqing.databindingstudy.viewModel.MainFramePresenter Presenter) {
        this.mPresenter = Presenter;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.presenter);
        super.requestRebind();
    }
    @Nullable
    public com.example.chansiqing.databindingstudy.viewModel.MainFramePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeItem((com.example.chansiqing.databindingstudy.data.MainFrameData) object, fieldId);
        }
        return false;
    }
    private boolean onChangeItem(com.example.chansiqing.databindingstudy.data.MainFrameData Item, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        boolean itemBtn1IsSimpleBtnVisible = false;
        int itemBtn4MarginVertical = 0;
        com.example.chansiqing.databindingstudy.data.MainFrameData item = mItem;
        android.view.View.OnClickListener presenterOnClickAndroidViewViewOnClickListener = null;
        com.example.chansiqing.databindingstudy.viewModel.MainFramePresenter presenter = mPresenter;
        int presenterIsVisibleItemBtn1IsSimpleBtnVisible = 0;
        com.example.chansiqing.databindingstudy.data.MainFrameData.ItemBtnData itemBtn3 = null;
        int itemBtn3MarginVertical = 0;
        java.lang.String itemBtn3GetSimpleBtnName = null;
        boolean itemBtn2IsSimpleBtnVisible = false;
        int itemBtn2MarginVertical = 0;
        boolean itemBtn4IsSimpleBtnVisible = false;
        com.example.chansiqing.databindingstudy.data.MainFrameData.ItemBtnData itemBtn2 = null;
        java.lang.String itemBtn4GetSimpleBtnName = null;
        int presenterIsVisibleItemBtn2IsSimpleBtnVisible = 0;
        boolean itemBtn3IsSimpleBtnVisible = false;
        int presenterIsVisibleItemBtn4IsSimpleBtnVisible = 0;
        com.example.chansiqing.databindingstudy.data.MainFrameData.ItemBtnData itemBtn1 = null;
        int presenterIsVisibleItemBtn3IsSimpleBtnVisible = 0;
        com.example.chansiqing.databindingstudy.data.MainFrameData.ItemBtnData itemBtn4 = null;
        java.lang.String itemBtn2SimpleBtnName = null;
        java.lang.String itemBtn1GetSimpleBtnName = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (item != null) {
                    // read item.btn3
                    itemBtn3 = item.getBtn3();
                    // read item.btn2
                    itemBtn2 = item.getBtn2();
                    // read item.btn1
                    itemBtn1 = item.getBtn1();
                    // read item.btn4
                    itemBtn4 = item.getBtn4();
                }

            if ((dirtyFlags & 0x5L) != 0) {

                    if (itemBtn3 != null) {
                        // read item.btn3.marginVertical
                        itemBtn3MarginVertical = itemBtn3.getMarginVertical();
                        // read item.btn3.getSimpleBtnName
                        itemBtn3GetSimpleBtnName = itemBtn3.getSimpleBtnName();
                    }
                    if (itemBtn2 != null) {
                        // read item.btn2.marginVertical
                        itemBtn2MarginVertical = itemBtn2.getMarginVertical();
                        // read item.btn2.simpleBtnName
                        itemBtn2SimpleBtnName = itemBtn2.getSimpleBtnName();
                    }
                    if (itemBtn1 != null) {
                        // read item.btn1.getSimpleBtnName
                        itemBtn1GetSimpleBtnName = itemBtn1.getSimpleBtnName();
                    }
                    if (itemBtn4 != null) {
                        // read item.btn4.marginVertical
                        itemBtn4MarginVertical = itemBtn4.getMarginVertical();
                        // read item.btn4.getSimpleBtnName
                        itemBtn4GetSimpleBtnName = itemBtn4.getSimpleBtnName();
                    }
            }

                if (itemBtn3 != null) {
                    // read item.btn3.isSimpleBtnVisible
                    itemBtn3IsSimpleBtnVisible = itemBtn3.isSimpleBtnVisible();
                }
                if (itemBtn2 != null) {
                    // read item.btn2.isSimpleBtnVisible
                    itemBtn2IsSimpleBtnVisible = itemBtn2.isSimpleBtnVisible();
                }
                if (itemBtn1 != null) {
                    // read item.btn1.isSimpleBtnVisible
                    itemBtn1IsSimpleBtnVisible = itemBtn1.isSimpleBtnVisible();
                }
                if (itemBtn4 != null) {
                    // read item.btn4.isSimpleBtnVisible
                    itemBtn4IsSimpleBtnVisible = itemBtn4.isSimpleBtnVisible();
                }


                if (presenter != null) {
                    // read presenter.isVisible(item.btn3.isSimpleBtnVisible)
                    presenterIsVisibleItemBtn3IsSimpleBtnVisible = presenter.isVisible(itemBtn3IsSimpleBtnVisible);
                    // read presenter.isVisible(item.btn2.isSimpleBtnVisible)
                    presenterIsVisibleItemBtn2IsSimpleBtnVisible = presenter.isVisible(itemBtn2IsSimpleBtnVisible);
                    // read presenter.isVisible(item.btn1.isSimpleBtnVisible)
                    presenterIsVisibleItemBtn1IsSimpleBtnVisible = presenter.isVisible(itemBtn1IsSimpleBtnVisible);
                    // read presenter.isVisible(item.btn4.isSimpleBtnVisible)
                    presenterIsVisibleItemBtn4IsSimpleBtnVisible = presenter.isVisible(itemBtn4IsSimpleBtnVisible);
                }
            if ((dirtyFlags & 0x6L) != 0) {

                    if (presenter != null) {
                        // read presenter::onClick
                        presenterOnClickAndroidViewViewOnClickListener = (((mPresenterOnClickAndroidViewViewOnClickListener == null) ? (mPresenterOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mPresenterOnClickAndroidViewViewOnClickListener).setValue(presenter));
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.btn1.setOnClickListener(presenterOnClickAndroidViewViewOnClickListener);
            this.btn3.setOnClickListener(presenterOnClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.btn1, itemBtn1GetSimpleBtnName);
            com.example.chansiqing.databindingstudy.utils.MyBindingAdapter.setMarginTop(this.btn2, itemBtn2MarginVertical);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.btn2, itemBtn2SimpleBtnName);
            com.example.chansiqing.databindingstudy.utils.MyBindingAdapter.setMarginTop(this.btn3, itemBtn3MarginVertical);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.btn3, itemBtn3GetSimpleBtnName);
            com.example.chansiqing.databindingstudy.utils.MyBindingAdapter.setMarginTop(this.btn4, itemBtn4MarginVertical);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.btn4, itemBtn4GetSimpleBtnName);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            this.btn1.setVisibility(presenterIsVisibleItemBtn1IsSimpleBtnVisible);
            this.btn2.setVisibility(presenterIsVisibleItemBtn2IsSimpleBtnVisible);
            this.btn3.setVisibility(presenterIsVisibleItemBtn3IsSimpleBtnVisible);
            this.btn4.setVisibility(presenterIsVisibleItemBtn4IsSimpleBtnVisible);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.btn2.setOnClickListener(mCallback1);
            this.btn4.setOnClickListener(mCallback2);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.example.chansiqing.databindingstudy.viewModel.MainFramePresenter value;
        public OnClickListenerImpl setValue(com.example.chansiqing.databindingstudy.viewModel.MainFramePresenter value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onClick(arg0);
        }
    }
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // presenter != null
                boolean presenterJavaLangObjectNull = false;
                // presenter
                com.example.chansiqing.databindingstudy.viewModel.MainFramePresenter presenter = mPresenter;



                presenterJavaLangObjectNull = (presenter) != (null);
                if (presenterJavaLangObjectNull) {



                    presenter.onClick(callbackArg_0);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // presenter != null
                boolean presenterJavaLangObjectNull = false;
                // presenter
                com.example.chansiqing.databindingstudy.viewModel.MainFramePresenter presenter = mPresenter;
                // item
                com.example.chansiqing.databindingstudy.data.MainFrameData item = mItem;
                // item != null
                boolean itemJavaLangObjectNull = false;
                // item.btn2
                com.example.chansiqing.databindingstudy.data.MainFrameData.ItemBtnData itemBtn2 = null;



                presenterJavaLangObjectNull = (presenter) != (null);
                if (presenterJavaLangObjectNull) {




                    itemJavaLangObjectNull = (item) != (null);
                    if (itemJavaLangObjectNull) {


                        itemBtn2 = item.getBtn2();

                        presenter.onClick(btn2, itemBtn2);
                    }
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityMainFrameBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainFrameBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityMainFrameBinding>inflate(inflater, com.example.chansiqing.databindingstudy.R.layout.activity_main_frame, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityMainFrameBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainFrameBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.chansiqing.databindingstudy.R.layout.activity_main_frame, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityMainFrameBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainFrameBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_main_frame_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityMainFrameBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): presenter
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}