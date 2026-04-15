package org.tester.l_ioExel;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.message.EntryMessage;
import org.apache.logging.log4j.message.FlowMessageFactory;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.util.MessageSupplier;
import org.apache.logging.log4j.util.Supplier;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @created : 30/03/2026,13:59,lun.
 **/
public class ExcelUtility {
    public void catching(Level level, Throwable throwable) {
        logg.catching(level, throwable);
    }

    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logg.trace(message, p0, p1, p2, p3, p4);
    }

    public boolean isWarnEnabled() {
        return logg.isWarnEnabled();
    }

    public void trace(Marker marker, CharSequence message, Throwable throwable) {
        logg.trace(marker, message, throwable);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logg.warn(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void error(Marker marker, String message) {
        logg.error(marker, message);
    }

    public void error(Marker marker, String message, Object p0, Object p1) {
        logg.error(marker, message, p0, p1);
    }

    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logg.error(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public boolean isEnabled(Level level, Marker marker) {
        return logg.isEnabled(level, marker);
    }

    public void fatal(String message, Object p0, Object p1, Object p2) {
        logg.fatal(message, p0, p1, p2);
    }

    public EntryMessage traceEntry(Supplier<?>... paramSuppliers) {
        return logg.traceEntry(paramSuppliers);
    }

    public void fatal(Marker marker, String message, Throwable throwable) {
        logg.fatal(marker, message, throwable);
    }

    public void warn(Supplier<?> messageSupplier) {
        logg.warn(messageSupplier);
    }

    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logg.debug(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void debug(Marker marker, String message, Object p0, Object p1) {
        logg.debug(marker, message, p0, p1);
    }

    public void debug(Marker marker, String message) {
        logg.debug(marker, message);
    }

    public void debug(Marker marker, CharSequence message) {
        logg.debug(marker, message);
    }

    public void error(Marker marker, CharSequence message) {
        logg.error(marker, message);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logg.fatal(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void info(String message, Object p0, Object p1, Object p2) {
        logg.info(message, p0, p1, p2);
    }

    public LogBuilder atInfo() {
        return logg.atInfo();
    }

    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logg.error(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void info(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {
        logg.info(marker, messageSupplier, throwable);
    }

    public void log(Level level, String message, Object p0) {
        logg.log(level, message, p0);
    }

    public void warn(String message, Object p0, Object p1, Object p2) {
        logg.warn(message, p0, p1, p2);
    }

    public void trace(Marker marker, Message message) {
        logg.trace(marker, message);
    }

    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logg.debug(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void info(Supplier<?> messageSupplier) {
        logg.info(messageSupplier);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logg.info(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logg.log(level, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void warn(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {
        logg.warn(marker, messageSupplier, throwable);
    }

    public void fatal(Marker marker, String message, Object p0) {
        logg.fatal(marker, message, p0);
    }

    public void log(Level level, MessageSupplier messageSupplier, Throwable throwable) {
        logg.log(level, messageSupplier, throwable);
    }

    public void error(Marker marker, String message, Object... params) {
        logg.error(marker, message, params);
    }

    public void trace(Marker marker, Supplier<?> messageSupplier) {
        logg.trace(marker, messageSupplier);
    }

    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logg.trace(message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void info(Marker marker, String message, Object p0) {
        logg.info(marker, message, p0);
    }

    public void log(Level level, Object message, Throwable throwable) {
        logg.log(level, message, throwable);
    }

    public void traceExit(EntryMessage message) {
        logg.traceExit(message);
    }

    public void warn(CharSequence message) {
        logg.warn(message);
    }

    public void debug(Marker marker, Message message) {
        logg.debug(marker, message);
    }

    public void log(Level level, MessageSupplier messageSupplier) {
        logg.log(level, messageSupplier);
    }

    public void log(Level level, Marker marker, String message, Object p0) {
        logg.log(level, marker, message, p0);
    }

    @Deprecated
    public <R> R exit(R result) {
        return logg.exit(result);
    }

    public void trace(Marker marker, CharSequence message) {
        logg.trace(marker, message);
    }

    public void warn(String message, Throwable throwable) {
        logg.warn(message, throwable);
    }

    public EntryMessage traceEntry(String format, Object... params) {
        return logg.traceEntry(format, params);
    }

    public void error(Marker marker, CharSequence message, Throwable throwable) {
        logg.error(marker, message, throwable);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2) {
        logg.fatal(marker, message, p0, p1, p2);
    }

    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logg.fatal(message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void info(Message message) {
        logg.info(message);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logg.warn(marker, message, p0, p1, p2, p3, p4);
    }

    public void debug(Marker marker, String message, Object... params) {
        logg.debug(marker, message, params);
    }

    public void info(Marker marker, Object message, Throwable throwable) {
        logg.info(marker, message, throwable);
    }

    @Deprecated
    public void entry(Object... params) {
        logg.entry(params);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2) {
        logg.log(level, message, p0, p1, p2);
    }

    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logg.trace(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public LogBuilder atFatal() {
        return logg.atFatal();
    }

    public void warn(Object message) {
        logg.warn(message);
    }

    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logg.error(message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void warn(Marker marker, Object message) {
        logg.warn(marker, message);
    }

    public void error(Marker marker, Message message) {
        logg.error(marker, message);
    }

    public void error(Marker marker, Supplier<?> messageSupplier) {
        logg.error(marker, messageSupplier);
    }

    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logg.error(message, p0, p1, p2, p3, p4);
    }

    public void warn(Supplier<?> messageSupplier, Throwable throwable) {
        logg.warn(messageSupplier, throwable);
    }

    public void trace(Marker marker, String message, Object... params) {
        logg.trace(marker, message, params);
    }

    public EntryMessage traceEntry(String format, Supplier<?>... paramSuppliers) {
        return logg.traceEntry(format, paramSuppliers);
    }

    public void warn(Marker marker, Object message, Throwable throwable) {
        logg.warn(marker, message, throwable);
    }

    public void info(MessageSupplier messageSupplier) {
        logg.info(messageSupplier);
    }

    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logg.info(message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void trace(Marker marker, String message) {
        logg.trace(marker, message);
    }

    public EntryMessage traceEntry(Message message) {
        return logg.traceEntry(message);
    }

    public void warn(Message message) {
        logg.warn(message);
    }

    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logg.debug(message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void info(Marker marker, MessageSupplier messageSupplier) {
        logg.info(marker, messageSupplier);
    }

    public void warn(Marker marker, String message, Object p0) {
        logg.warn(marker, message, p0);
    }

    public void trace(Marker marker, String message, Object p0, Object p1) {
        logg.trace(marker, message, p0, p1);
    }

    public void log(Level level, Marker marker, Supplier<?> messageSupplier, Throwable throwable) {
        logg.log(level, marker, messageSupplier, throwable);
    }

    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logg.debug(message, p0, p1, p2, p3, p4);
    }

    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logg.trace(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2) {
        logg.info(marker, message, p0, p1, p2);
    }

    public void warn(Marker marker, MessageSupplier messageSupplier) {
        logg.warn(marker, messageSupplier);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2) {
        logg.warn(marker, message, p0, p1, p2);
    }

    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logg.warn(message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logg.fatal(marker, message, p0, p1, p2, p3, p4);
    }

    public void info(CharSequence message) {
        logg.info(message);
    }

    public void debug(Marker marker, Supplier<?> messageSupplier) {
        logg.debug(marker, messageSupplier);
    }

    public void log(Level level, Marker marker, String message, Throwable throwable) {
        logg.log(level, marker, message, throwable);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logg.log(level, message, p0, p1, p2, p3, p4);
    }

    public void fatal(Marker marker, String message) {
        logg.fatal(marker, message);
    }

    public void warn(MessageSupplier messageSupplier) {
        logg.warn(messageSupplier);
    }

    public <T extends Throwable> T throwing(T throwable) {
        return logg.throwing(throwable);
    }

    public void log(Level level, Marker marker, Message message, Throwable throwable) {
        logg.log(level, marker, message, throwable);
    }

    public void info(String message, Throwable throwable) {
        logg.info(message, throwable);
    }

    public void debug(Marker marker, CharSequence message, Throwable throwable) {
        logg.debug(marker, message, throwable);
    }

    public void debug(String message, Object p0) {
        logg.debug(message, p0);
    }

    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logg.error(message, p0, p1, p2, p3, p4, p5);
    }

    public void debug(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {
        logg.debug(marker, messageSupplier, throwable);
    }

    public void info(Object message) {
        logg.info(message);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3) {
        logg.log(level, message, p0, p1, p2, p3);
    }

    public void error(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {
        logg.error(marker, messageSupplier, throwable);
    }

    public void debug(Marker marker, Message message, Throwable throwable) {
        logg.debug(marker, message, throwable);
    }

    public void error(Marker marker, Message message, Throwable throwable) {
        logg.error(marker, message, throwable);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logg.warn(marker, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logg.log(level, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public <R> R traceExit(EntryMessage message, R result) {
        return logg.traceExit(message, result);
    }

    public void warn(Marker marker, String message, Supplier<?>... paramSuppliers) {
        logg.warn(marker, message, paramSuppliers);
    }

    public void warn(MessageSupplier messageSupplier, Throwable throwable) {
        logg.warn(messageSupplier, throwable);
    }

    public String getName() {
        return logg.getName();
    }

    public void info(Supplier<?> messageSupplier, Throwable throwable) {
        logg.info(messageSupplier, throwable);
    }

    public void log(Level level, Marker marker, CharSequence message, Throwable throwable) {
        logg.log(level, marker, message, throwable);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        logg.warn(marker, message, p0, p1, p2, p3);
    }

    public void error(String message, Object p0) {
        logg.error(message, p0);
    }

    public void info(Marker marker, Object message) {
        logg.info(marker, message);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logg.info(marker, message, p0, p1, p2, p3, p4);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logg.log(level, marker, message, p0, p1, p2, p3, p4);
    }

    public void info(String message) {
        logg.info(message);
    }

    public void logMessage(Level level, Marker marker, String fqcn, StackTraceElement location, Message message, Throwable throwable) {
        logg.logMessage(level, marker, fqcn, location, message, throwable);
    }

    public void log(Level level, Object message) {
        logg.log(level, message);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logg.trace(marker, message, p0, p1, p2, p3, p4, p5);
    }

    public void log(Level level, Marker marker, MessageSupplier messageSupplier, Throwable throwable) {
        logg.log(level, marker, messageSupplier, throwable);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logg.fatal(marker, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void warn(CharSequence message, Throwable throwable) {
        logg.warn(message, throwable);
    }

    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logg.debug(message, p0, p1, p2, p3, p4, p5);
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logg.error(marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void fatal(Marker marker, CharSequence message) {
        logg.fatal(marker, message);
    }

    public void error(String message, Object p0, Object p1, Object p2, Object p3) {
        logg.error(message, p0, p1, p2, p3);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        logg.fatal(marker, message, p0, p1, p2, p3);
    }

    public void info(String message, Supplier<?>... paramSuppliers) {
        logg.info(message, paramSuppliers);
    }

    public boolean isErrorEnabled(Marker marker) {
        return logg.isErrorEnabled(marker);
    }

    public void log(Level level, Marker marker, Object message, Throwable throwable) {
        logg.log(level, marker, message, throwable);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logg.info(marker, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void warn(String message) {
        logg.warn(message);
    }

    public void fatal(Marker marker, String message, Object... params) {
        logg.fatal(marker, message, params);
    }

    public void info(Message message, Throwable throwable) {
        logg.info(message, throwable);
    }

    public void traceExit() {
        logg.traceExit();
    }

    public void error(String message, Object... params) {
        logg.error(message, params);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logg.debug(marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public Level getLevel() {
        return logg.getLevel();
    }

    public void info(Marker marker, String message, Supplier<?>... paramSuppliers) {
        logg.info(marker, message, paramSuppliers);
    }

    public void catching(Throwable throwable) {
        logg.catching(throwable);
    }

    public void warn(String message, Supplier<?>... paramSuppliers) {
        logg.warn(message, paramSuppliers);
    }

    public void error(String message, Object p0, Object p1) {
        logg.error(message, p0, p1);
    }

    public void info(MessageSupplier messageSupplier, Throwable throwable) {
        logg.info(messageSupplier, throwable);
    }

    public void log(Level level, String message, Supplier<?>... paramSuppliers) {
        logg.log(level, message, paramSuppliers);
    }

    public void warn(Message message, Throwable throwable) {
        logg.warn(message, throwable);
    }

    public LogBuilder atTrace() {
        return logg.atTrace();
    }

    public void debug(String message, Object p0, Object p1, Object p2, Object p3) {
        logg.debug(message, p0, p1, p2, p3);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        logg.info(marker, message, p0, p1, p2, p3);
    }

    public void error(Object message, Throwable throwable) {
        logg.error(message, throwable);
    }

    public void warn(String message, Object p0, Object p1, Object p2, Object p3) {
        logg.warn(message, p0, p1, p2, p3);
    }

    public void trace(Marker marker, String message, Throwable throwable) {
        logg.trace(marker, message, throwable);
    }

    public void debug(Object message, Throwable throwable) {
        logg.debug(message, throwable);
    }

    public void debug(String message, Object p0, Object p1) {
        logg.debug(message, p0, p1);
    }

    public boolean isDebugEnabled() {
        return logg.isDebugEnabled();
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logg.error(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void fatal(Marker marker, Message message) {
        logg.fatal(marker, message);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logg.fatal(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void info(CharSequence message, Throwable throwable) {
        logg.info(message, throwable);
    }

    public boolean isWarnEnabled(Marker marker) {
        return logg.isWarnEnabled(marker);
    }

    public void fatal(Marker marker, Supplier<?> messageSupplier) {
        logg.fatal(marker, messageSupplier);
    }

    public void fatal(String message, Object p0, Object p1) {
        logg.fatal(message, p0, p1);
    }

    public void error(CharSequence message, Throwable throwable) {
        logg.error(message, throwable);
    }

    public void fatal(Marker marker, CharSequence message, Throwable throwable) {
        logg.fatal(marker, message, throwable);
    }

    public void info(String message, Object p0, Object p1) {
        logg.info(message, p0, p1);
    }

    public boolean isInfoEnabled(Marker marker) {
        return logg.isInfoEnabled(marker);
    }

    @Deprecated
    public void entry() {
        logg.entry();
    }

    public void debug(String message, Object... params) {
        logg.debug(message, params);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logg.info(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    @Deprecated
    public void exit() {
        logg.exit();
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logg.debug(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void info(Object message, Throwable throwable) {
        logg.info(message, throwable);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logg.warn(marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void log(Level level, Marker marker, String message, Object... params) {
        logg.log(level, marker, message, params);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logg.log(level, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void debug(MessageSupplier messageSupplier, Throwable throwable) {
        logg.debug(messageSupplier, throwable);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        logg.debug(marker, message, p0, p1, p2, p3);
    }

    public void error(MessageSupplier messageSupplier, Throwable throwable) {
        logg.error(messageSupplier, throwable);
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        logg.error(marker, message, p0, p1, p2, p3);
    }

    public void debug(Marker marker, String message, Supplier<?>... paramSuppliers) {
        logg.debug(marker, message, paramSuppliers);
    }

    public void printf(Level level, Marker marker, String format, Object... params) {
        logg.printf(level, marker, format, params);
    }

    public void error(Marker marker, String message, Supplier<?>... paramSuppliers) {
        logg.error(marker, message, paramSuppliers);
    }

    public void fatal(String message, Object p0, Object p1, Object p2, Object p3) {
        logg.fatal(message, p0, p1, p2, p3);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logg.debug(marker, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void info(String message, Object... params) {
        logg.info(message, params);
    }

    public void warn(Object message, Throwable throwable) {
        logg.warn(message, throwable);
    }

    public LogBuilder atWarn() {
        return logg.atWarn();
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logg.log(level, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void debug(String message, Supplier<?>... paramSuppliers) {
        logg.debug(message, paramSuppliers);
    }

    public void error(Message message, Throwable throwable) {
        logg.error(message, throwable);
    }

    public void debug(CharSequence message, Throwable throwable) {
        logg.debug(message, throwable);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logg.fatal(marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logg.log(level, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logg.error(marker, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void fatal(Marker marker, Message message, Throwable throwable) {
        logg.fatal(marker, message, throwable);
    }

    public void error(String message, Supplier<?>... paramSuppliers) {
        logg.error(message, paramSuppliers);
    }

    public void info(String message, Object p0, Object p1, Object p2, Object p3) {
        logg.info(message, p0, p1, p2, p3);
    }

    public void warn(String message, Object... params) {
        logg.warn(message, params);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logg.warn(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void warn(String message, Object p0, Object p1) {
        logg.warn(message, p0, p1);
    }

    public boolean isFatalEnabled() {
        return logg.isFatalEnabled();
    }

    public void fatal(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {
        logg.fatal(marker, messageSupplier, throwable);
    }

    public void fatal(String message, Object p0) {
        logg.fatal(message, p0);
    }

    public void trace(Supplier<?> messageSupplier) {
        logg.trace(messageSupplier);
    }

    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logg.fatal(message, p0, p1, p2, p3, p4, p5);
    }

    public void log(Level level, Message message, Throwable throwable) {
        logg.log(level, message, throwable);
    }

    public void error(String message) {
        logg.error(message);
    }

    public void debug(Marker marker, Object message) {
        logg.debug(marker, message);
    }

    public <T extends Throwable> T throwing(Level level, T throwable) {
        return logg.throwing(level, throwable);
    }

    public void debug(Object message) {
        logg.debug(message);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logg.info(marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void error(Supplier<?> messageSupplier, Throwable throwable) {
        logg.error(messageSupplier, throwable);
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logg.error(marker, message, p0, p1, p2, p3, p4);
    }

    public void info(Marker marker, Message message, Throwable throwable) {
        logg.info(marker, message, throwable);
    }

    public void debug(Message message, Throwable throwable) {
        logg.debug(message, throwable);
    }

    public void warn(Marker marker, Supplier<?> messageSupplier) {
        logg.warn(marker, messageSupplier);
    }

    public void warn(Marker marker, CharSequence message, Throwable throwable) {
        logg.warn(marker, message, throwable);
    }

    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logg.warn(message, p0, p1, p2, p3, p4);
    }

    public void info(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {
        logg.info(marker, messageSupplier, throwable);
    }

    public void error(Marker marker, Object message) {
        logg.error(marker, message);
    }

    public void error(Object message) {
        logg.error(message);
    }

    public void info(String message, Object p0) {
        logg.info(message, p0);
    }

    public boolean isTraceEnabled() {
        return logg.isTraceEnabled();
    }

    public void trace(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {
        logg.trace(marker, messageSupplier, throwable);
    }

    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logg.info(message, p0, p1, p2, p3, p4, p5);
    }

    public void log(Level level, Supplier<?> messageSupplier, Throwable throwable) {
        logg.log(level, messageSupplier, throwable);
    }

    public LogBuilder always() {
        return logg.always();
    }

    public void debug(String message) {
        logg.debug(message);
    }

    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logg.warn(message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void debug(String message, Throwable throwable) {
        logg.debug(message, throwable);
    }

    public void error(String message, Throwable throwable) {
        logg.error(message, throwable);
    }

    public void log(Level level, Marker marker, Supplier<?> messageSupplier) {
        logg.log(level, marker, messageSupplier);
    }

    public void trace(Marker marker, MessageSupplier messageSupplier) {
        logg.trace(marker, messageSupplier);
    }

    public void warn(String message, Object p0) {
        logg.warn(message, p0);
    }

    public void trace(String message, Object p0, Object p1, Object p2) {
        logg.trace(message, p0, p1, p2);
    }

    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logg.warn(message, p0, p1, p2, p3, p4, p5);
    }

    public void debug(MessageSupplier messageSupplier) {
        logg.debug(messageSupplier);
    }

    public void error(CharSequence message) {
        logg.error(message);
    }

    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logg.fatal(message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void log(Level level, Marker marker, MessageSupplier messageSupplier) {
        logg.log(level, marker, messageSupplier);
    }

    public void trace(Message message) {
        logg.trace(message);
    }

    public void warn(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {
        logg.warn(marker, messageSupplier, throwable);
    }

    public void fatal(String message, Object... params) {
        logg.fatal(message, params);
    }

    public void log(Level level, CharSequence message, Throwable throwable) {
        logg.log(level, message, throwable);
    }

    public void warn(Marker marker, Message message, Throwable throwable) {
        logg.warn(marker, message, throwable);
    }

    public void debug(Supplier<?> messageSupplier, Throwable throwable) {
        logg.debug(messageSupplier, throwable);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logg.debug(marker, message, p0, p1, p2, p3, p4);
    }

    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logg.debug(message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void error(Marker marker, MessageSupplier messageSupplier) {
        logg.error(marker, messageSupplier);
    }

    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logg.fatal(message, p0, p1, p2, p3, p4);
    }

    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logg.info(message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2) {
        logg.error(marker, message, p0, p1, p2);
    }

    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logg.error(message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void log(Level level, Marker marker, Message message) {
        logg.log(level, marker, message);
    }

    public void trace(Marker marker, Object message, Throwable throwable) {
        logg.trace(marker, message, throwable);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1) {
        logg.log(level, marker, message, p0, p1);
    }

    public void trace(Marker marker, String message, Object p0) {
        logg.trace(marker, message, p0);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logg.trace(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void debug(CharSequence message) {
        logg.debug(message);
    }

    public void error(MessageSupplier messageSupplier) {
        logg.error(messageSupplier);
    }

    public void info(Marker marker, CharSequence message, Throwable throwable) {
        logg.info(marker, message, throwable);
    }

    public <R> R traceExit(String format, R result) {
        return logg.traceExit(format, result);
    }

    public void fatal(Object message, Throwable throwable) {
        logg.fatal(message, throwable);
    }

    public void debug(Marker marker, Object message, Throwable throwable) {
        logg.debug(marker, message, throwable);
    }

    public void info(Marker marker, Supplier<?> messageSupplier) {
        logg.info(marker, messageSupplier);
    }

    public void log(Level level, Marker marker, CharSequence message) {
        logg.log(level, marker, message);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logg.trace(marker, message, p0, p1, p2, p3, p4);
    }

    public void error(Marker marker, Object message, Throwable throwable) {
        logg.error(marker, message, throwable);
    }

    public void info(Marker marker, Message message) {
        logg.info(marker, message);
    }

    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logg.info(message, p0, p1, p2, p3, p4);
    }

    public void debug(Marker marker, String message, Object p0) {
        logg.debug(marker, message, p0);
    }

    public void error(Message message) {
        logg.error(message);
    }

    public void trace(CharSequence message) {
        logg.trace(message);
    }

    public void fatal(CharSequence message, Throwable throwable) {
        logg.fatal(message, throwable);
    }

    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logg.warn(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void trace(String message, Throwable throwable) {
        logg.trace(message, throwable);
    }

    public void warn(Marker marker, CharSequence message) {
        logg.warn(marker, message);
    }

    public void debug(Marker marker, MessageSupplier messageSupplier) {
        logg.debug(marker, messageSupplier);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2) {
        logg.debug(marker, message, p0, p1, p2);
    }

    public void log(Level level, Supplier<?> messageSupplier) {
        logg.log(level, messageSupplier);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        logg.log(level, marker, message, p0, p1, p2, p3);
    }

    public void debug(Message message) {
        logg.debug(message);
    }

    public void log(Level level, Message message) {
        logg.log(level, message);
    }

    public void error(Marker marker, String message, Object p0) {
        logg.error(marker, message, p0);
    }

    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logg.fatal(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void trace(MessageSupplier messageSupplier) {
        logg.trace(messageSupplier);
    }

    public void fatal(MessageSupplier messageSupplier, Throwable throwable) {
        logg.fatal(messageSupplier, throwable);
    }

    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logg.info(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void log(Level level, CharSequence message) {
        logg.log(level, message);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2) {
        logg.log(level, marker, message, p0, p1, p2);
    }

    public void trace(Message message, Throwable throwable) {
        logg.trace(message, throwable);
    }

    public void info(Marker marker, String message, Object... params) {
        logg.info(marker, message, params);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2) {
        logg.trace(marker, message, p0, p1, p2);
    }

    public void fatal(Marker marker, String message, Supplier<?>... paramSuppliers) {
        logg.fatal(marker, message, paramSuppliers);
    }

    public LogBuilder atDebug() {
        return logg.atDebug();
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logg.error(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void fatal(String message, Supplier<?>... paramSuppliers) {
        logg.fatal(message, paramSuppliers);
    }

    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logg.trace(message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void warn(Marker marker, Message message) {
        logg.warn(marker, message);
    }

    public void error(Supplier<?> messageSupplier) {
        logg.error(messageSupplier);
    }

    public void trace(String message) {
        logg.trace(message);
    }

    public <R> R traceExit(R result) {
        return logg.traceExit(result);
    }

    public void debug(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {
        logg.debug(marker, messageSupplier, throwable);
    }

    public void fatal(Message message, Throwable throwable) {
        logg.fatal(message, throwable);
    }

    public void log(Level level, String message, Object... params) {
        logg.log(level, message, params);
    }

    public void debug(String message, Object p0, Object p1, Object p2) {
        logg.debug(message, p0, p1, p2);
    }

    public void error(String message, Object p0, Object p1, Object p2) {
        logg.error(message, p0, p1, p2);
    }

    public void info(Marker marker, CharSequence message) {
        logg.info(marker, message);
    }

    public void fatal(String message) {
        logg.fatal(message);
    }

    public void log(Level level, Marker marker, Object message) {
        logg.log(level, marker, message);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logg.log(level, marker, message, p0, p1, p2, p3, p4, p5);
    }

    public void debug(Supplier<?> messageSupplier) {
        logg.debug(messageSupplier);
    }

    public <MF extends MessageFactory> MF getMessageFactory() {
        return logg.getMessageFactory();
    }

    public void trace(Marker marker, Object message) {
        logg.trace(marker, message);
    }

    public void trace(Object message) {
        logg.trace(message);
    }

    public void warn(Marker marker, String message, Object... params) {
        logg.warn(marker, message, params);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logg.debug(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void error(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {
        logg.error(marker, messageSupplier, throwable);
    }

    public void trace(Supplier<?> messageSupplier, Throwable throwable) {
        logg.trace(messageSupplier, throwable);
    }

    public void trace(CharSequence message, Throwable throwable) {
        logg.trace(message, throwable);
    }

    public EntryMessage traceEntry() {
        return logg.traceEntry();
    }

    public boolean isDebugEnabled(Marker marker) {
        return logg.isDebugEnabled(marker);
    }

    public void fatal(Object message) {
        logg.fatal(message);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1) {
        logg.fatal(marker, message, p0, p1);
    }

    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logg.fatal(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logg.log(level, marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void fatal(Marker marker, Object message) {
        logg.fatal(marker, message);
    }

    public void log(Level level, Marker marker, String message, Supplier<?>... paramSuppliers) {
        logg.log(level, marker, message, paramSuppliers);
    }

    public void fatal(Supplier<?> messageSupplier, Throwable throwable) {
        logg.fatal(messageSupplier, throwable);
    }

    public void log(Level level, String message) {
        logg.log(level, message);
    }

    public void trace(Marker marker, String message, Supplier<?>... paramSuppliers) {
        logg.trace(marker, message, paramSuppliers);
    }

    public void trace(MessageSupplier messageSupplier, Throwable throwable) {
        logg.trace(messageSupplier, throwable);
    }

    public void info(Marker marker, String message, Object p0, Object p1) {
        logg.info(marker, message, p0, p1);
    }

    public LogBuilder atError() {
        return logg.atError();
    }

    public void log(Level level, Marker marker, String message) {
        logg.log(level, marker, message);
    }

    public void fatal(CharSequence message) {
        logg.fatal(message);
    }

    public void log(Level level, String message, Object p0, Object p1) {
        logg.log(level, message, p0, p1);
    }

    public void trace(String message, Supplier<?>... paramSuppliers) {
        logg.trace(message, paramSuppliers);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logg.trace(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void trace(String message, Object p0, Object p1) {
        logg.trace(message, p0, p1);
    }

    public void info(Marker marker, String message) {
        logg.info(marker, message);
    }

    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logg.info(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void fatal(String message, Throwable throwable) {
        logg.fatal(message, throwable);
    }

    public void trace(String message, Object... params) {
        logg.trace(message, params);
    }

    public void warn(Marker marker, String message, Object p0, Object p1) {
        logg.warn(marker, message, p0, p1);
    }

    public void fatal(MessageSupplier messageSupplier) {
        logg.fatal(messageSupplier);
    }

    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logg.warn(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logg.trace(marker, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void error(Marker marker, String message, Throwable throwable) {
        logg.error(marker, message, throwable);
    }

    public void trace(Object message, Throwable throwable) {
        logg.trace(message, throwable);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        logg.trace(marker, message, p0, p1, p2, p3);
    }

    public void fatal(Marker marker, MessageSupplier messageSupplier) {
        logg.fatal(marker, messageSupplier);
    }

    public void fatal(Message message) {
        logg.fatal(message);
    }

    public void warn(Marker marker, String message) {
        logg.warn(marker, message);
    }

    public boolean isFatalEnabled(Marker marker) {
        return logg.isFatalEnabled(marker);
    }

    public void fatal(Marker marker, Object message, Throwable throwable) {
        logg.fatal(marker, message, throwable);
    }

    public void debug(Marker marker, String message, Throwable throwable) {
        logg.debug(marker, message, throwable);
    }

    public LogBuilder atLevel(Level level) {
        return logg.atLevel(level);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logg.log(level, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logg.trace(marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public FlowMessageFactory getFlowMessageFactory() {
        return logg.getFlowMessageFactory();
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logg.fatal(marker, message, p0, p1, p2, p3, p4, p5);
    }

    public void warn(Marker marker, String message, Throwable throwable) {
        logg.warn(marker, message, throwable);
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logg.error(marker, message, p0, p1, p2, p3, p4, p5);
    }

    public void printf(Level level, String format, Object... params) {
        logg.printf(level, format, params);
    }

    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logg.trace(message, p0, p1, p2, p3, p4, p5);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logg.info(marker, message, p0, p1, p2, p3, p4, p5);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logg.log(level, marker, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void trace(String message, Object p0) {
        logg.trace(message, p0);
    }

    public <R> R traceExit(Message message, R result) {
        return logg.traceExit(message, result);
    }

    public void fatal(Supplier<?> messageSupplier) {
        logg.fatal(messageSupplier);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logg.log(level, message, p0, p1, p2, p3, p4, p5);
    }

    public boolean isEnabled(Level level) {
        return logg.isEnabled(level);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logg.debug(marker, message, p0, p1, p2, p3, p4, p5);
    }

    public boolean isTraceEnabled(Marker marker) {
        return logg.isTraceEnabled(marker);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logg.warn(marker, message, p0, p1, p2, p3, p4, p5);
    }

    public void fatal(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {
        logg.fatal(marker, messageSupplier, throwable);
    }

    public boolean isErrorEnabled() {
        return logg.isErrorEnabled();
    }

    public boolean isInfoEnabled() {
        return logg.isInfoEnabled();
    }

    public void log(Level level, String message, Throwable throwable) {
        logg.log(level, message, throwable);
    }

    public void trace(Marker marker, Message message, Throwable throwable) {
        logg.trace(marker, message, throwable);
    }

    public void trace(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {
        logg.trace(marker, messageSupplier, throwable);
    }

    public void trace(String message, Object p0, Object p1, Object p2, Object p3) {
        logg.trace(message, p0, p1, p2, p3);
    }

    public void info(Marker marker, String message, Throwable throwable) {
        logg.info(marker, message, throwable);
    }

    Logger logg= LogManager.getLogger(ExcelUtility.class);
    //Read from excel
    public String readDataFromExcelColum(String fileN, String sheetN, int rowNm, int colimNm) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileN);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = workbook.getSheet(sheetN);
        XSSFRow row = sheet.getRow(rowNm);
        String colimnValue=null;
        if (row == null) {
            logg.info("Empty row");
        } else {
            XSSFCell cell = row.getCell(colimNm);
            CellType type=cell.getCellType();
            switch (type){
                case STRING : colimnValue=cell.getStringCellValue();
                break;
                case NUMERIC:
                    colimnValue=String.valueOf(cell.getNumericCellValue());
                    break;
            }


        }
        return colimnValue;
    }
}
