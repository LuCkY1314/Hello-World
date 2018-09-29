package chansiqing.myapplication

import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.Exception
import kotlin.concurrent.thread

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-07-25 17:25
 */
class KotlinTest {

    companion object StaticMethod {
        interface Test {
            fun printFuckWord(string: String)
        }

        fun testSwitch(x: Int) {
            when (x) {
                in 1..10 -> System.out.print("$x in 1-10")
                !in 11..20 -> System.out.print("$x not in 11-20")
                else -> System.out.print("$x is out of control")
            }
        }

        fun <T> doPrint(content: T) {
            when (content) {
                is String -> print("$content is String")
                is Int -> print("$content is Int")
                is Boolean -> print("$content is boolean")
            }
        }

        fun testSynchronizedLock() {
            var count = 0
            var reentrantLock = ReentrantReadWriteLock()
            for (i in 1..100) {
                Thread(Runnable {
                    synchronized(count) {
                        count++
                        println("in thread do it -->>count number is $count and run $i times")
                    }
                }).start()
                println("every time do it -->>count number is $count and run $i times")
            }
            println("final -->>count number is $count")
        }

        fun testReentrantReadWriteLock() {
            var count = 0
            var lock = ReentrantLock()
            for (i in 1..100) {
                Thread(Runnable {
                    lock.lock()
                    try {
                        count++
                        println("in thread do it -->>count number is $count and run $i times")
                    } catch (e: Exception) {

                    } finally {
                        lock.unlock()
                    }
                }).start()
            }
            Thread.sleep(2000)
        }

        fun testReentrantReadWriteTryLock() {
            var count = 0
            var lock = ReentrantLock()
            for (i in 1..100) {
                var thread = Thread(Runnable {
                    if (lock.tryLock()) {
                        try {
                            count++
                            println("in thread do it -->>count number is $count and run $i times")
                        } catch (e: Exception) {

                        } finally {
                            lock.unlock()
                        }
                    } else {
                        println("run $i times count,number is $count")
                    }
                })
                thread.start()
                thread.interrupt()
            }
            Thread.sleep(3000)
            println("final -->>count number is $count")
        }

        fun testReentrantLock() {
            var count = 0
            var lock = ReentrantReadWriteLock()
            var condition: Condition = lock.writeLock().newCondition()
            var thread = thread {
                kotlin.run {
                    try {
                        lock.writeLock().lock()
                        count++
                        println("in thread do it -->>count number is $count")
                        condition.await()
                        println("in thread do it again-->>count number is $count")
                    } catch (e: Exception) {

                    } finally {
                        lock.writeLock().unlock()
                    }
                }
            }
            var thread1 = thread {
                kotlin.run {
                    try {
                        lock.writeLock().lock()
                        count++
                        condition.await()
                        println("in thread1 do it -->>count number is $count")
                    } catch (e: Exception) {

                    } finally {
                        lock.writeLock().unlock()
                    }
                }
            }
            thread.start()
            thread1.start()
            Thread.sleep(3000)
            println("final -->>count number is $count")
        }
    }

}