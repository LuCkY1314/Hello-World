package com.example.chansiqing.databindingstudy.databinding;
import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FloorAutoAdapterBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    public final android.widget.EditText edit;
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    public final android.widget.SeekBar seekBar;
    @NonNull
    public final android.widget.TextView text;
    // variables
    @Nullable
    private com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData mItem;
    @Nullable
    private com.example.chansiqing.databindingstudy.viewModel.AutoAdapterFloorPresenter mPresenter;
    @Nullable
    private com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData mModel;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener editandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of presenter.countDefault(item.count)
            //         is item.setCount((java.lang.String) presenter.countDefaultBack(callbackArg_0))
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(edit);
            // localize variables for thread safety
            // presenter.countDefaultBack(callbackArg_0)
            java.lang.String presenterCountDefaultBackCallbackArg0 = null;
            // presenter != null
            boolean presenterJavaLangObjectNull = false;
            // presenter
            com.example.chansiqing.databindingstudy.viewModel.AutoAdapterFloorPresenter presenter = mPresenter;
            // item
            com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData item = mItem;
            // item != null
            boolean itemJavaLangObjectNull = false;
            // item.count
            java.lang.String itemCount = null;
            // presenter.countDefault(item.count)
            java.lang.String presenterCountDefaultItemCount = null;
            // (java.lang.String) presenter.countDefaultBack(callbackArg_0)
            java.lang.String javaLangStringPresenterCountDefaultBackCallbackArg0 = null;



            itemJavaLangObjectNull = (item) != (null);
            if (itemJavaLangObjectNull) {



                presenterJavaLangObjectNull = (presenter) != (null);
                if (presenterJavaLangObjectNull) {



                    presenterCountDefaultBackCallbackArg0 = presenter.countDefaultBack(callbackArg_0);

                    javaLangStringPresenterCountDefaultBackCallbackArg0 = ((java.lang.String) (presenterCountDefaultBackCallbackArg0));

                    item.setCount(javaLangStringPresenterCountDefaultBackCallbackArg0);
                }
            }
        }
    };
    private android.databinding.InverseBindingListener seekBarandroidProgressAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of presenter.countToInt(item.count)
            //         is item.setCount((java.lang.String) presenter.countToIntBack(callbackArg_0))
            int callbackArg_0 = seekBar.getProgress();
            // localize variables for thread safety
            // presenter.countToIntBack(callbackArg_0)
            java.lang.String presenterCountToIntBackCallbackArg0 = null;
            // presenter != null
            boolean presenterJavaLangObjectNull = false;
            // presenter
            com.example.chansiqing.databindingstudy.viewModel.AutoAdapterFloorPresenter presenter = mPresenter;
            // presenter.countToInt(item.count)
            int presenterCountToIntItemCount = 0;
            // item
            com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData item = mItem;
            // item != null
            boolean itemJavaLangObjectNull = false;
            // item.count
            java.lang.String itemCount = null;
            // (java.lang.String) presenter.countToIntBack(callbackArg_0)
            java.lang.String javaLangStringPresenterCountToIntBackCallbackArg0 = null;



            itemJavaLangObjectNull = (item) != (null);
            if (itemJavaLangObjectNull) {



                presenterJavaLangObjectNull = (presenter) != (null);
                if (presenterJavaLangObjectNull) {



                    presenterCountToIntBackCallbackArg0 = presenter.countToIntBack(callbackArg_0);

                    javaLangStringPresenterCountToIntBackCallbackArg0 = ((java.lang.String) (presenterCountToIntBackCallbackArg0));

                    item.setCount(javaLangStringPresenterCountToIntBackCallbackArg0);
                }
            }
        }
    };

    public FloorAutoAdapterBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 2);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.edit = (android.widget.EditText) bindings[2];
        this.edit.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.seekBar = (android.widget.SeekBar) bindings[3];
        this.seekBar.setTag(null);
        this.text = (android.widget.TextView) bindings[1];
        this.text.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
            setItem((com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData) variable);
        }
        else if (BR.presenter == variableId) {
            setPresenter((com.example.chansiqing.databindingstudy.viewModel.AutoAdapterFloorPresenter) variable);
        }
        else if (BR.model == variableId) {
            setModel((com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData Item) {
        updateRegistration(0, Item);
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    @Nullable
    public com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData getItem() {
        return mItem;
    }
    public void setPresenter(@Nullable com.example.chansiqing.databindingstudy.viewModel.AutoAdapterFloorPresenter Presenter) {
        this.mPresenter = Presenter;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.presenter);
        super.requestRebind();
    }
    @Nullable
    public com.example.chansiqing.databindingstudy.viewModel.AutoAdapterFloorPresenter getPresenter() {
        return mPresenter;
    }
    public void setModel(@Nullable com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData Model) {
        updateRegistration(1, Model);
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }
    @Nullable
    public com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData getModel() {
        return mModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeItem((com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData) object, fieldId);
            case 1 :
                return onChangeModel((com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData) object, fieldId);
        }
        return false;
    }
    private boolean onChangeItem(com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData Item, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.count) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModel(com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData Model, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        com.example.chansiqing.databindingstudy.data.AutoAdapterFloorData item = mItem;
        com.example.chansiqing.databindingstudy.viewModel.AutoAdapterFloorPresenter presenter = mPresenter;
        int presenterCountToIntItemCount = 0;
        java.lang.String presenterCountDefaultItemCount = null;
        java.lang.String itemCount = null;
        com.example.chansiqing.databindingstudy.data.BindingAdapterTestFloorData model = mModel;
        java.lang.String javaLangStringPresenterCountDefaultItemCount = null;

        if ((dirtyFlags & 0x1dL) != 0) {



                if (item != null) {
                    // read item.count
                    itemCount = item.getCount();
                }


                if (presenter != null) {
                    // read presenter.countToInt(item.count)
                    presenterCountToIntItemCount = presenter.countToInt(itemCount);
                    // read presenter.countDefault(item.count)
                    presenterCountDefaultItemCount = presenter.countDefault(itemCount);
                }


                // read ("当前进度是 ") + (presenter.countDefault(item.count))
                javaLangStringPresenterCountDefaultItemCount = ("当前进度是 ") + (presenterCountDefaultItemCount);
        }
        if ((dirtyFlags & 0x12L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x1dL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.edit, presenterCountDefaultItemCount);
            android.databinding.adapters.SeekBarBindingAdapter.setProgress(this.seekBar, presenterCountToIntItemCount);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.text, javaLangStringPresenterCountDefaultItemCount);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edit, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editandroidTextAttrChanged);
            android.databinding.adapters.SeekBarBindingAdapter.setOnSeekBarChangeListener(this.seekBar, (android.databinding.adapters.SeekBarBindingAdapter.OnStartTrackingTouch)null, (android.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch)null, (android.databinding.adapters.SeekBarBindingAdapter.OnProgressChanged)null, seekBarandroidProgressAttrChanged);
        }
        if ((dirtyFlags & 0x12L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, com.example.chansiqing.databindingstudy.viewModel.BindingAdapterTestFloorPresenter.convertDataToString(model));
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FloorAutoAdapterBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FloorAutoAdapterBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FloorAutoAdapterBinding>inflate(inflater, com.example.chansiqing.databindingstudy.R.layout.floor_auto_adapter, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FloorAutoAdapterBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FloorAutoAdapterBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.chansiqing.databindingstudy.R.layout.floor_auto_adapter, null, false), bindingComponent);
    }
    @NonNull
    public static FloorAutoAdapterBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FloorAutoAdapterBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/floor_auto_adapter_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FloorAutoAdapterBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): model
        flag 2 (0x3L): presenter
        flag 3 (0x4L): item.count
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}