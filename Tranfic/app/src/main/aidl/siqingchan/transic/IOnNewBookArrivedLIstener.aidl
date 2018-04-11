// IOnNewBookArrivedLIstener.aidl
package siqingchan.transic;
import siqingchan.transic.Book;
// Declare any non-default types here with import statements

interface IOnNewBookArrivedListener {

    void onNewBookArrived(in Book newBook);
}
