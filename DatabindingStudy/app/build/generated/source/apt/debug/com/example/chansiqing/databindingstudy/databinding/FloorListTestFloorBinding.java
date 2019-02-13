package com.example.chansiqing.databindingstudy.databinding;
import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FloorListTestFloorBinding extends android.databinding.ViewDataBinding  {

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
    private com.example.chansiqing.databindingstudy.data.ListTestFloorData mItem;
    @Nullable
    private com.example.chansiqing.databindingstudy.viewModel.ListTestFloorPresenter mPresenter;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FloorListTestFloorBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
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
            setItem((com.example.chansiqing.databindingstudy.data.ListTestFloorData) variable);
        }
        else if (BR.presenter == variableId) {
            setPresenter((com.example.chansiqing.databindingstudy.viewModel.ListTestFloorPresenter) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.example.chansiqing.databindingstudy.data.ListTestFloorData Item) {
        updateRegistration(0, Item);
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    @Nullable
    public com.example.chansiqing.databindingstudy.data.ListTestFloorData getItem() {
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
            case 0 :
                return onChangeItem((com.example.chansiqing.databindingstudy.data.ListTestFloorData) object, fieldId);
        }
        return false;
    }
    private boolean onChangeItem(com.example.chansiqing.databindingstudy.data.ListTestFloorData Item, int fieldId) {
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
        com.example.chansiqing.databindingstudy.data.ListTestFloorData item = mItem;
        com.example.chansiqing.databindingstudy.viewModel.ListTestFloorPresenter presenter = mPresenter;
        java.util.ArrayList<com.example.chansiqing.databindingstudy.data.ListTestFloorItemData> presenterPrepareAdapterRecycleItem = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (presenter != null) {
                    // read presenter.prepareAdapter(recycle, item)
                    presenterPrepareAdapterRecycleItem = presenter.prepareAdapter(recycle, item);
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            com.example.chansiqing.databindingstudy.utils.MyBindingAdapter.setData(this.recycle, presenterPrepareAdapterRecycleItem);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FloorListTestFloorBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FloorListTestFloorBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FloorListTestFloorBinding>inflate(inflater, com.example.chansiqing.databindingstudy.R.layout.floor_list_test_floor, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FloorListTestFloorBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FloorListTestFloorBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.chansiqing.databindingstudy.R.layout.floor_list_test_floor, null, false), bindingComponent);
    }
    @NonNull
    public static FloorListTestFloorBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FloorListTestFloorBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/floor_list_test_floor_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FloorListTestFloorBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): presenter
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}