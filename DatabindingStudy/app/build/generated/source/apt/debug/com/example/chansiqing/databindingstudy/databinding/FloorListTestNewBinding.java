package com.example.chansiqing.databindingstudy.databinding;
import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FloorListTestNewBinding extends android.databinding.ViewDataBinding  {

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
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    public final com.example.chansiqing.databindingstudy.view.MyRecycleView recycle;
    // variables
    @Nullable
    private java.util.ArrayList<com.example.chansiqing.databindingstudy.data.ListTestFloorItemData> mItem;
    @Nullable
    private com.example.chansiqing.databindingstudy.viewModel.ListTestFloorPresenter mPresenter;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FloorListTestNewBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.recycle = (com.example.chansiqing.databindingstudy.view.MyRecycleView) bindings[1];
        this.recycle.setTag(null);
        setRootTag(root);
        // listeners
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
            setItem((java.util.ArrayList<com.example.chansiqing.databindingstudy.data.ListTestFloorItemData>) variable);
        }
        else if (BR.presenter == variableId) {
            setPresenter((com.example.chansiqing.databindingstudy.viewModel.ListTestFloorPresenter) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable java.util.ArrayList<com.example.chansiqing.databindingstudy.data.ListTestFloorItemData> Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    @Nullable
    public java.util.ArrayList<com.example.chansiqing.databindingstudy.data.ListTestFloorItemData> getItem() {
        return mItem;
    }
    public void setPresenter(@Nullable com.example.chansiqing.databindingstudy.viewModel.ListTestFloorPresenter Presenter) {
        this.mPresenter = Presenter;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.presenter);
        super.requestRebind();
    }
    @Nullable
    public com.example.chansiqing.databindingstudy.viewModel.ListTestFloorPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        java.util.ArrayList<com.example.chansiqing.databindingstudy.data.ListTestFloorItemData> item = mItem;
        com.example.chansiqing.databindingstudy.viewModel.ListTestFloorPresenter presenter = mPresenter;
        java.util.ArrayList<com.example.chansiqing.databindingstudy.data.ListTestFloorItemData> presenterPrepareAdapterNewRecycleItem = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (presenter != null) {
                    // read presenter.prepareAdapterNew(recycle, item)
                    presenterPrepareAdapterNewRecycleItem = presenter.prepareAdapterNew(recycle, item);
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            com.example.chansiqing.databindingstudy.utils.MyBindingAdapter.setData(this.recycle, presenterPrepareAdapterNewRecycleItem);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FloorListTestNewBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FloorListTestNewBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FloorListTestNewBinding>inflate(inflater, com.example.chansiqing.databindingstudy.R.layout.floor_list_test_new, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FloorListTestNewBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FloorListTestNewBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.chansiqing.databindingstudy.R.layout.floor_list_test_new, null, false), bindingComponent);
    }
    @NonNull
    public static FloorListTestNewBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FloorListTestNewBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/floor_list_test_new_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FloorListTestNewBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): presenter
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}