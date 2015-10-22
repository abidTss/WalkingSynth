package com.dobi.walkingsynth;
import android.content.Context;
import android.graphics.Color;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class AccelerometerGraph {

    public static final int THRESH_INIT = 12;
    public static final String THRESH = "Thresh";

    private static final int GRAPH_RESOLUTION = 150;
    private static final String TITLE = "Accelerometer data";

    private GraphicalView view;

    private int datasetsCount = 2;
    private double mThreshVal = THRESH_INIT;
    private TimeSeries mMeasLine;
    private TimeSeries[] mSeries = new TimeSeries[AccOptions.size];
    private XYSeriesRenderer[] mRenderers = new XYSeriesRenderer[AccOptions.size];
    private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
    private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();

    public boolean isPainting = true;
    private int mPointsCount = 0;
    private int[] mOffset = new int[AccOptions.size];

    public AccelerometerGraph() {
        // add single data set to multiple data set
        for (int i = 0; i < datasetsCount; i++) {
            mSeries[i] = new TimeSeries(TITLE + (i + 1));
            mDataset.addSeries(mSeries[i]);
            mRenderers[i] = new XYSeriesRenderer();
            mRenderers[i].setPointStyle(PointStyle.CIRCLE);
            mRenderers[i].setFillPoints(true);
            mRenderer.addSeriesRenderer(mRenderers[i]);
        }
        mRenderers[0].setColor(Color.RED);
        mRenderers[1].setColor(Color.BLUE);
        // add measurement line
        addThresholdLine();
        // customize general view
        mRenderer.clearXTextLabels();
        mRenderer.setYTitle("Acc value");
        mRenderer.setYAxisMin(0);
        mRenderer.setYAxisMax(20);
        mRenderer.setMarginsColor(Color.WHITE);
        mRenderer.setBackgroundColor(Color.WHITE);
        mRenderer.setApplyBackgroundColor(true);
        mRenderer.setXLabels(0);
        mRenderer.setClickEnabled(true);
        mRenderer.setPanEnabled(false, false);
        mRenderer.setZoomEnabled(false, false);
    }

    public void addNewPoints(double t, double[] v) {
        for (int i = 0; i < datasetsCount; ++i) {
            // moving plot
            mSeries[i].add(t, v[i] + mOffset[i]);
            mMeasLine.add(t, mThreshVal);
            if (mPointsCount > GRAPH_RESOLUTION) {
                mSeries[i].remove(0);
                mMeasLine.remove(0);
            }
        }
        if (isPainting)
            view.repaint();
        ++mPointsCount;
    }

    public void setThresholdVal(double v) {
        mThreshVal = v;
    }

    public double getThresholdVal() {
        return mThreshVal;
    }


    public void addThresholdLine() {
        mMeasLine = new TimeSeries(THRESH);
        mDataset.addSeries(mMeasLine);
        XYSeriesRenderer renderer = new XYSeriesRenderer();
        renderer.setLineWidth(2f);
        renderer.setColor(Color.BLACK);
        mRenderer.addSeriesRenderer(renderer);

    }

    public void isPainting(boolean v) {
        isPainting = v;
    }

    public void setVisibility(int opt, boolean show) {
        //AccOptions option = AccOptions.values()[opt];
        if (show) {
            // show current option
            mRenderers[opt].setColor(Color.BLUE);
            // show current option
        } else {
            mRenderers[opt].setColor(Color.TRANSPARENT);
        }
        view.repaint();
    }

    public void initialize() {
        // reset the point counter
        mPointsCount = 0;
    }

    public void addOffset(int i, int v) {
        mOffset[i] = v;
    }


    public void clear() {
//        for (TimeSeries ts : mSeries) {
//            ts.clear();
//        }
    }

    public GraphicalView getView(Context context){
        view =  ChartFactory.getLineChartView(context, mDataset, mRenderer);
        return view;
    }
}