package com.example.chansiqing.databindingstudy.databinding;
import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ViewFlipperChildBinding extends android.databinding.ViewDataBinding  {

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
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    public final com.example.chansiqing.databindingstudy.view.SpecSimpleDrawee photo;
    @NonNull
    public final android.widget.TextView text;
    // variables
    @Nullable
    private com.example.chansiqing.databindingstudy.data.FlipperData mItem;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ViewFlipperChildBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.photo = (com.example.chansiqing.databindingstudy.view.SpecSimpleDrawee) bindings[1];
        this.photo.setTag(null);
        this.text = (android.widget.TextView) bindings[2];
        this.text.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
            setItem((com.example.chansiqing.databindingstudy.data.FlipperData) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.example.chansiqing.databindingstudy.data.FlipperData Item) {
        updateRegistration(0, Item);
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    @Nullable
    public com.example.chansiqing.databindingstudy.data.FlipperData getItem() {
        return mItem;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeItem((com.example.chansiqing.databindingstudy.data.FlipperData) object, fieldId);
        }
        return false;
    }
    private boolean onChangeItem(com.example.chansiqing.databindingstudy.data.FlipperData Item, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.url) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.text) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        com.example.chansiqing.databindingstudy.data.FlipperData item = mItem;
        java.lang.String itemText = null;
        java.lang.String itemUrl = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (item != null) {
                        // read item.text
                        itemText = item.getText();
                    }
            }
            if ((dirtyFlags & 0xbL) != 0) {

                    if (item != null) {
                        // read item.url
                        itemUrl = item.getUrl();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xbL) != 0) {
            // api target 1

            com.example.chansiqing.databindingstudy.utils.MyBindingAdapter.setImageUrl(this.photo, itemUrl);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.text, itemText);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ViewFlipperChildBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ViewFlipperChildBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ViewFlipperChildBinding>inflate(inflater, com.example.chansiqing.databindingstudy.R.layout.view_flipper_child, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ViewFlipperChildBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ViewFlipperChildBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.chansiqing.databindingstudy.R.layout.view_flipper_child, null, false), bindingComponent);
    }
    @NonNull
    public static ViewFlipperChildBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ViewFlipperChildBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/view_flipper_child_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ViewFlipperChildBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): item.url
        flag 2 (0x3L): item.text
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}