
import java.io._
import java.time.temporal.ChronoUnit
import java.time.{LocalDateTime, Period}
import scala.collection.mutable.ListBuffer
import scala.io.Source


class WriteThread(totalTime : Int) extends Thread {
    override def run(): Unit = {
        println("WriteThread Running..")
        val file = new File("CurrentTime.txt")
        println(file.lastModified() + "- At the Begining of WriteThread")
        println()
        val writer = new BufferedWriter(new FileWriter("CurrentTime.txt"))
        var timeElapsed = 0
        while(timeElapsed < totalTime) {
            val currentTime = LocalDateTime.now()
            val output = s"$currentTime\n"
            println(currentTime + "- Current Time")
            writer.write(output)
            timeElapsed += 1
            writer.flush()

            Thread.sleep(1000) // Wait for 1 second before writing again
        }
        writer.write("0")
        writer.flush()
        writer.close()
        println(file.lastModified() + "- At the end of WriteThread")
        println("WriteThread Finished")

    }
}

class ReadThread extends Thread {
    override def run(): Unit = {
        println("ReadThread Running..")
        val time = ListBuffer[Long]()
        val writer = new BufferedWriter(new FileWriter("TimeDiff.txt"))
        val file = new File("CurrentTime.txt")
        var flag = 0
        var lastMod = file.lastModified()
        while(flag == 0) {
            val file = new File("CurrentTime.txt")
            if(file.lastModified() != lastMod) {
                println(lastMod + " -> " +file.lastModified() + " - Last modified when changed")
                lastMod = file.lastModified()
                val lines = Source.fromFile("CurrentTime.txt").getLines().toList
                val currTime = lines.last
                try {
                    val CurrTimeInFormat = LocalDateTime.parse(currTime)
                    println(CurrTimeInFormat + " - Curr Last")
                    val timeDiff = ChronoUnit.MILLIS.between(CurrTimeInFormat, LocalDateTime.now())
                    println(timeDiff + "ms Time diff")
                    time += timeDiff
                    writer.write(CurrTimeInFormat+ " " + timeDiff + "ms \n")
                    writer.flush()
                }catch {
                    case e: Exception => println("Ignore case")
                }
                if(lines.last == "0") flag = 1
            }
        }
        val min = time.min
        val max = time.max
        val avg : Double = time.sum/time.length
        writer.write("Min : " + min + " Max : " + max + " Avg : " + avg)
        writer.close()
        println("ReadThread Finished")
    }
}

object Main extends App{
    val totalTime = 3
    println("Program starts")
    val t1 = new WriteThread(totalTime)
    val t2 = new ReadThread()
    t1.start()
    t2.start()
}
