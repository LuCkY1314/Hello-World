package com.example.chansiqing.databindingstudy.databinding;
import com.example.chansiqing.databindingstudy.R;
import com.example.chansiqing.databindingstudy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ListItemListFloorBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.icon, 5);
    }
    // views
    @NonNull
    public final com.facebook.drawee.view.SimpleDraweeView icon;
    @NonNull
    public final com.facebook.drawee.view.SimpleDraweeView img;
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    public final android.widget.TextView nameTv;
    @NonNull
    public final android.widget.TextView priceTv;
    @NonNull
    public final android.widget.TextView timeTv;
    // variables
    @Nullable
    private com.example.chansiqing.databindingstudy.data.ListTestFloorItemData mItem;
    @Nullable
    private com.example.chansiqing.databindingstudy.viewModel.ListTestFloorItemPresenter mPresenter;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ListItemListFloorBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.icon = (com.facebook.drawee.view.SimpleDraweeView) bindings[5];
        this.img = (com.facebook.drawee.view.SimpleDraweeView) bindings[1];
        this.img.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.nameTv = (android.widget.TextView) bindings[2];
        this.nameTv.setTag(null);
        this.priceTv = (android.widget.TextView) bindings[4];
        this.priceTv.setTag(null);
        this.timeTv = (android.widget.TextView) bindings[3];
        this.timeTv.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
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
            setItem((com.example.chansiqing.databindingstudy.data.ListTestFloorItemData) variable);
        }
        else if (BR.presenter == variableId) {
            setPresenter((com.example.chansiqing.databindingstudy.viewModel.ListTestFloorItemPresenter) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.example.chansiqing.databindingstudy.data.ListTestFloorItemData Item) {
        updateRegistration(0, Item);
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    @Nullable
    public com.example.chansiqing.databindingstudy.data.ListTestFloorItemData getItem() {
        return mItem;
    }
    public void setPresenter(@Nullable com.example.chansiqing.databindingstudy.viewModel.ListTestFloorItemPresenter Presenter) {
        this.mPresenter = Presenter;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.presenter);
        super.requestRebind();
    }
    @Nullable
    public com.example.chansiqing.databindingstudy.viewModel.ListTestFloorItemPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeItem((com.example.chansiqing.databindingstudy.data.ListTestFloorItemData) object, fieldId);
        }
        return false;
    }
    private boolean onChangeItem(com.example.chansiqing.databindingstudy.data.ListTestFloorItemData Item, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.marginHorizon) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.imgUrl) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.name) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        else if (fieldId == BR.price) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
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
        com.example.chansiqing.databindingstudy.data.ListTestFloorItemData item = mItem;
        com.example.chansiqing.databindingstudy.viewModel.ListTestFloorItemPresenter presenter = mPresenter;
        int itemMarginHorizon = 0;
        int presenterNumberToPxItemMarginHorizon = 0;
        long itemTime = 0L;
        java.lang.String itemPrice = null;
        java.lang.String javaLangStringPresenterNumberToDateItemTime = null;
        java.lang.String itemImgUrl = null;
        java.lang.String itemPriceJavaLangString = null;
        java.lang.String itemName = null;
        java.lang.String presenterNumberToDateItemTime = null;

        if ((dirtyFlags & 0x7fL) != 0) {


            if ((dirtyFlags & 0x47L) != 0) {

                    if (item != null) {
                        // read item.marginHorizon
                        itemMarginHorizon = item.getMarginHorizon();
                    }
            }
            if ((dirtyFlags & 0x43L) != 0) {

                    if (item != null) {
                        // read item.time
                        itemTime = item.getTime();
                    }
            }
            if ((dirtyFlags & 0x61L) != 0) {

                    if (item != null) {
                        // read item.price
                        itemPrice = item.getPrice();
                    }


                    // read (item.price) + ("元")
                    itemPriceJavaLangString = (itemPrice) + ("元");
            }
            if ((dirtyFlags & 0x49L) != 0) {

                    if (item != null) {
                        // read item.imgUrl
                        itemImgUrl = item.getImgUrl();
                    }
            }
            if ((dirtyFlags & 0x51L) != 0) {

                    if (item != null) {
                        // read item.name
                        itemName = item.getName();
                    }
            }
        }
        if ((dirtyFlags & 0x47L) != 0) {



                if (presenter != null) {
                    // read presenter.numberToPx(item.marginHorizon)
                    presenterNumberToPxItemMarginHorizon = presenter.numberToPx(itemMarginHorizon);
                }
            if ((dirtyFlags & 0x43L) != 0) {

                    if (presenter != null) {
                        // read presenter.numberToDate(item.time)
                        presenterNumberToDateItemTime = presenter.numberToDate(itemTime);
                    }


                    // read ("发布时间：") + (presenter.numberToDate(item.time))
                    javaLangStringPresenterNumberToDateItemTime = ("发布时间：") + (presenterNumberToDateItemTime);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x49L) != 0) {
            // api target 1

            com.example.chansiqing.databindingstudy.utils.MyBindingAdapter.setImageUrl(this.img, itemImgUrl);
        }
        if ((dirtyFlags & 0x47L) != 0) {
            // api target 1

            com.example.chansiqing.databindingstudy.utils.MyBindingAdapter.setMarginLeft(this.mboundView0, presenterNumberToPxItemMarginHorizon);
            com.example.chansiqing.databindingstudy.utils.MyBindingAdapter.setMarginRight(this.mboundView0, presenterNumberToPxItemMarginHorizon);
        }
        if ((dirtyFlags & 0x51L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.nameTv, itemName);
        }
        if ((dirtyFlags & 0x61L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.priceTv, itemPriceJavaLangString);
        }
        if ((dirtyFlags & 0x43L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.timeTv, javaLangStringPresenterNumberToDateItemTime);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ListItemListFloorBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ListItemListFloorBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ListItemListFloorBinding>inflate(inflater, com.example.chansiqing.databindingstudy.R.layout.list_item_list_floor, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ListItemListFloorBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ListItemListFloorBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.chansiqing.databindingstudy.R.layout.list_item_list_floor, null, false), bindingComponent);
    }
    @NonNull
    public static ListItemListFloorBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ListItemListFloorBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/list_item_list_floor_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ListItemListFloorBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): presenter
        flag 2 (0x3L): item.marginHorizon
        flag 3 (0x4L): item.imgUrl
        flag 4 (0x5L): item.name
        flag 5 (0x6L): item.price
        flag 6 (0x7L): null
    flag mapping end*/
    //end
}