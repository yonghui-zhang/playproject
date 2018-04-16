package com.zyh.bpnn;

import javax.swing.text.TabableView;

public class Bp {

    private double[] hide1_x;
    private double[][] hide1_w;
    private double[] hide1_errors;

    private double[] out_x;
    private double[][] out_w;
    private double[] out_errors;

    private double[] target;

    private double rate;

    public Bp(int input_node, int hide1_node, int out_node, double rate)
    {
        super();
        hide1_x = new double[input_node+1];

        hide1_w = new double[hide1_node][input_node+1];
        hide1_errors = new double[hide1_node];

        out_x = new double[hide1_node+1];
        out_w = new double[out_node][hide1_node+1];
        out_errors = new double[out_node];

        target = new double[out_node];

        this.rate = rate;

        init_weight();
    }
    public void init_weight()
    {
        set_weight(hide1_w);
        set_weight(out_w);
    }

    private void set_weight(double[][] w)
    {
        for (int i=0;i<w.length;i++)
        {
            for (int j=0;j<w[i].length;j++)
            {
                w[i][j] = 0;
            }
        }
    }
    private void setHide1_x(double[] Data)
    {
        if (Data.length != hide1_x.length - 1)
        {
            throw new IllegalArgumentException("数据大小与输出层节点不匹配");
        }
        System.arraycopy(Data, 0, hide1_x, 1, Data.length);
        hide1_x[0] = 1.0;
    }
    private void setTarget(double[] target)
    {
        this.target = target;
    }

    public void train(double[] TrainData, double[] target)
    {
        setHide1_x(TrainData);
        setTarget(target);

        double[] output = new double[out_w.length+1];
        forword(hide1_x, output);

        backpropagation(output);

    }

    public void backpropagation(double[] output)
    {
        get_out_error(output, target, out_errors);

        get_hide_error(out_errors, out_w, out_x, hide1_errors);

        update_weight(hide1_errors, hide1_w, hide1_x);

        update_weight(out_errors, out_w, out_x);

    }

    public void predict(double[] data, double[] output)
    {
        double[] out_y = new double[out_w.length+1];
        setHide1_x(data);
        forword(hide1_x, out_y);
        System.arraycopy(out_y, 1, output, 0, output.length);
    }

    public void update_weight(double[] err, double[][] w, double[] x)
    {
        double newweight = 0.0;
        for (int i=0;i<w.length;i++)
        {
            for (int j=0;j<w[i].length;j++)
            {
                newweight = rate * err[i] * x[j];
                w[i][j] = w[i][j] + newweight;
            }
        }
    }

    public void get_out_error(double[] output, double[] target, double[] out_error)
    {
        for (int i=0;i<target.length;i++)
        {
            out_error[i] = (target[i] - output[i+1]) * output[i+1] * (1d - output[i+1]);
        }
    }

    public void get_hide_error(double[] NeLaErr, double[][] Nextw, double[] output, double[] error)
    {
        for (int k=0;k<error.length;k++)
        {
            double sum = 0;
            for (int j=0;j<Nextw.length;j++)
            {
                sum += Nextw[j][k+1] * NeLaErr[j];
            }
            error[k] = sum * output[k+1] * (1d - output[k+1]);
        }
    }

    public void forword(double[] x, double[] output)
    {
        get_net_out(x, hide1_w, out_x);
        get_net_out(out_x, out_w, output);
    }

    private double get_node_put(double[] x, double[] w)
    {
        double z = 0d;

        for (int i=0;i<x.length;i++)
        {
            z += x[i] * w[i];
        }
        return 1d / (1d + Math.exp(-z));
    }

    private void get_net_out(double[] x, double[][] w, double[] net_out)
    {
          net_out[0] = 1d;
          for (int i=0;i<w.length;i++)
          {
              net_out[i+1] = get_node_put(x, w[i]);
          }
    }
}
