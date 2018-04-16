// IOnNewBookArrivedLIstener.aidl
package siqingchan.transic.aidl;
import siqingchan.transic.aidl.Book;
// Declare any non-default types here with import statements

interface IOnNewBookArrivedListener {

    void onNewBookArrived(in Book newBook);
}
