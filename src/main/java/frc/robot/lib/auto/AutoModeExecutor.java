// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.lib.auto;

/**
 * This class selects, runs, and (if necessary) stops a specified autonomous mode.
 */
public class AutoModeExecutor {
    private static AutoModeExecutor mInstance = null;

    private AutoModeBase mAutoMode = null;
    private Thread mThread = null;

    public AutoModeExecutor() {}

    public static AutoModeExecutor getInstance() {
        if (mInstance == null) {
            mInstance = new AutoModeExecutor();
        }

        return mInstance;
    }

    public void setAutoMode(AutoModeBase new_auto_mode) {
        mAutoMode = new_auto_mode;
    }

    public void start() {
        if (mThread != null) {
            mThread.start();
        }
    }

    public boolean isStarted() {
        return mAutoMode != null && mAutoMode.isActive() && mThread != null && mThread.isAlive();
    }

    public void reset() {
        if (isStarted()) {
            stop();
        }

        mAutoMode = null;
    }

    public void stop() {
        if (mAutoMode != null) {
            mAutoMode.stop();
        }

        mThread = null;
    }

    public AutoModeBase getAutoMode() {
        return mAutoMode;
    }

    public boolean isInterrupted() {
        if (mAutoMode == null) {
            return false;
        }
        return mAutoMode.getIsInterrupted();
    }

    public void interrupt() {
        if (mAutoMode == null) {
            return;
        }
        mAutoMode.interrupt();
    }

    public void resume() {
        if (mAutoMode == null) {
            return;
        }
        mAutoMode.resume();
    }
}